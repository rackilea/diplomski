import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer implements ReadableByteChannel {

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    private int readIndex = 0;
    private int writeIndex = 0;
    private int size = 0;

    private final int capacity;
    private final byte[] buff;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.buff = new byte[capacity];
    }

    /**
     * Deposit bytes to the buffer. Will only write until
     * buffer is full.
     * @param bytes the bytes to add
     * @return the number of bytes actually added
     */
    public int addBytes(byte[] bytes) {
        lock.lock();
        int writeCount = 0;
        try {
            int available = capacity - size;
            writeCount = available <= bytes.length ? available : bytes.length;
            for (int i = 0; i < writeCount; ++i) {
                buff[writeIndex] = bytes[i];
                incrementWrite();
                ++size;
            }
            // notify callers waiting on read()
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        return writeCount;
    }

    public int addBytes(byte[] bytes, int offset, int length) {
        lock.lock();
        int writeCount = 0;
        try {
            int available = capacity - size;
            writeCount = available <= length ? available : length;
            for (int i = 0; i <writeCount; ++i) {
                buff[writeIndex] = bytes[offset + i];
                incrementWrite();
                ++size;
            }
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        return writeCount;
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        lock.lock();
        try {
            // if the current size is 0, wait until data is added
            while (size == 0) {
                notEmpty.wait();
            }
            int attempt = byteBuffer.remaining();
            int readCount = attempt <= size ? attempt : size;
            for (int i = 0; i < readCount; ++i) {
                byteBuffer.put(buff[readIndex]);
                incrementRead();
                --size;
            }
            return readCount;
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            return 0;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void close() throws IOException {
        // do nothing
    }

    private final void incrementRead() {
        // increment and wrap around if necessary
        if (++readIndex == capacity) {
            readIndex = 0;
        }
    }

    private final void incrementWrite() {
        // increment and wrap around if necessary
        if (++writeIndex == capacity) {
            writeIndex = 0;
        }
    }

    public static void main(String[] args) {
        final Buffer buff = new Buffer(1024);
        final Scanner scanner = new Scanner(buff).useDelimiter("!");

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (scanner.hasNext()) {
                    String message = scanner.next();
                    System.out.println(message);
                    if (message.equals("goodbye")) {
                        return;
                    }
                }
            }
        });
        readThread.start();

        buff.addBytes("hello,".getBytes());
        buff.addBytes(" world!".getBytes());
        buff.addBytes("good".getBytes());
        buff.addBytes("bye!".getBytes());
    }
}
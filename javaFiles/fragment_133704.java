import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.concurrent.*;

public class FileCompare {

    private static final int MIN_BUFFER_SIZE = 1024 * 8;
    private static final int MAX_BUFFER_SIZE = 1024 * 1024;
    private String fileName1;
    private String fileName2;
    private long start;
    private long totalbytes;

    @Before
    public void createInputStream() {
        fileName1 = "bigFile.1";
        fileName2 = "bigFile.2";
    }

    @Test
    public void compareTwoFiles() throws IOException {
        System.out.println("comparing just with two streams");
        int currentBufferSize = MIN_BUFFER_SIZE;
        while (currentBufferSize <= MAX_BUFFER_SIZE) {
            compareWithBufferSize(currentBufferSize);
            currentBufferSize *= 2;
        }
    }

    @Test
    public void compareTwoFilesFutures() 
            throws IOException, ExecutionException, InterruptedException {
        System.out.println("comparing with threads");
        int myBufferSize = MIN_BUFFER_SIZE;
        while (myBufferSize <= MAX_BUFFER_SIZE) {
            start = System.currentTimeMillis();
            totalbytes = 0;
            compareWithBufferSizeFutures(myBufferSize);
            myBufferSize *= 2;
        }
    }

    @Test
    public void compareTwoFilesNio() throws IOException {
        System.out.println("comparing with nio");
        int myBufferSize = MIN_BUFFER_SIZE;
        while (myBufferSize <= MAX_BUFFER_SIZE) {
            start = System.currentTimeMillis();
            totalbytes = 0;
            boolean wasEqual = isEqualsNio(myBufferSize);

            if (wasEqual) {
                printAfterEquals(myBufferSize);
            } else {
                Assert.fail("files were not equal");
            }

            myBufferSize *= 2;
        }

    }

    private void compareWithBufferSize(int myBufferSize) throws IOException {
        final BufferedInputStream inputStream1 =
                new BufferedInputStream(
                        new FileInputStream(new File(fileName1)),
                        myBufferSize);
        byte[] buff1 = new byte[myBufferSize];
        final BufferedInputStream inputStream2 =
                new BufferedInputStream(
                        new FileInputStream(new File(fileName2)),
                        myBufferSize);
        byte[] buff2 = new byte[myBufferSize];
        int read1;

        start = System.currentTimeMillis();
        totalbytes = 0;
        while ((read1 = inputStream1.read(buff1)) != -1) {
            totalbytes += read1;
            int read2 = inputStream2.read(buff2);
            if (read1 != read2) {
                break;
            }
            if (!Arrays.equals(buff1, buff2)) {
                break;
            }
        }
        if (read1 == -1) {
            printAfterEquals(myBufferSize);
        } else {
            Assert.fail("files were not equal");
        }
        inputStream1.close();
        inputStream2.close();
    }

    private void compareWithBufferSizeFutures(int myBufferSize)
            throws ExecutionException, InterruptedException, IOException {
        final BufferedInputStream inputStream1 =
                new BufferedInputStream(
                        new FileInputStream(
                                new File(fileName1)),
                        myBufferSize);
        final BufferedInputStream inputStream2 =
                new BufferedInputStream(
                        new FileInputStream(
                                new File(fileName2)),
                        myBufferSize);

        final boolean wasEqual = isEqualsParallel(myBufferSize, inputStream1, inputStream2);

        if (wasEqual) {
            printAfterEquals(myBufferSize);
        } else {
            Assert.fail("files were not equal");
        }
        inputStream1.close();
        inputStream2.close();
    }

    private boolean isEqualsParallel(int myBufferSize
            , final BufferedInputStream inputStream1
            , final BufferedInputStream inputStream2)
            throws InterruptedException, ExecutionException {
        final byte[] buff1Even = new byte[myBufferSize];
        final byte[] buff1Odd = new byte[myBufferSize];
        final byte[] buff2Even = new byte[myBufferSize];
        final byte[] buff2Odd = new byte[myBufferSize];
        final Callable<Integer> read1Even = new Callable<Integer>() {
            public Integer call() throws Exception {
                return inputStream1.read(buff1Even);
            }
        };
        final Callable<Integer> read2Even = new Callable<Integer>() {
            public Integer call() throws Exception {
                return inputStream2.read(buff2Even);
            }
        };
        final Callable<Integer> read1Odd = new Callable<Integer>() {
            public Integer call() throws Exception {
                return inputStream1.read(buff1Odd);
            }
        };
        final Callable<Integer> read2Odd = new Callable<Integer>() {
            public Integer call() throws Exception {
                return inputStream2.read(buff2Odd);
            }
        };
        final Callable<Boolean> oddEqualsArray = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Arrays.equals(buff1Odd, buff2Odd);
            }
        };
        final Callable<Boolean> evenEqualsArray = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return Arrays.equals(buff1Even, buff2Even);
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        boolean isEven = true;
        Future<Integer> read1 = null;
        Future<Integer> read2 = null;
        Future<Boolean> isEqual = null;
        int lastSize = 0;
        while (true) {
            if (isEqual != null) {
                if (!isEqual.get()) {
                    return false;
                } else if (lastSize == -1) {
                    return true;
                }
            }
            if (read1 != null) {
                lastSize = read1.get();
                totalbytes += lastSize;
                final int size2 = read2.get();
                if (lastSize != size2) {
                    return false;
                }
            }
            isEven = !isEven;
            if (isEven) {
                if (read1 != null) {
                    isEqual = executor.submit(oddEqualsArray);
                }
                read1 = executor.submit(read1Even);
                read2 = executor.submit(read2Even);
            } else {
                if (read1 != null) {
                    isEqual = executor.submit(evenEqualsArray);
                }
                read1 = executor.submit(read1Odd);
                read2 = executor.submit(read2Odd);
            }
        }
    }

    private boolean isEqualsNio(int myBufferSize) throws IOException {
        FileChannel first = null, seconde = null;
        try {
            first = new FileInputStream(fileName1).getChannel();
            seconde = new FileInputStream(fileName2).getChannel();
            if (first.size() != seconde.size()) {
                return false;
            }
            ByteBuffer firstBuffer = ByteBuffer.allocateDirect(myBufferSize);
            ByteBuffer secondBuffer = ByteBuffer.allocateDirect(myBufferSize);
            int firstRead, secondRead;
            while (first.position() < first.size()) {
                firstRead = first.read(firstBuffer);
                totalbytes += firstRead;
                secondRead = seconde.read(secondBuffer);
                if (firstRead != secondRead) {
                    return false;
                }
                if (!nioBuffersEqual(firstBuffer, secondBuffer, firstRead)) {
                    return false;
                }
            }
            return true;
        } finally {
            if (first != null) {
                first.close();
            }
            if (seconde != null) {
                seconde.close();
            }
        }
    }

    private static boolean nioBuffersEqual(ByteBuffer first, ByteBuffer second, final int length) {
        if (first.limit() != second.limit() || length > first.limit()) {
            return false;
        }
        first.rewind();
        second.rewind();
        for (int i = 0; i < length; i++) {
            if (first.get() != second.get()) {
                return false;
            }
        }
        return true;
    }

    private void printAfterEquals(int myBufferSize) {
        NumberFormat nf = new DecimalFormat("#.00");
        final long dur = System.currentTimeMillis() - start;
        double seconds = dur / 1000d;
        double megabytes = totalbytes / 1024 / 1024;
        double rate = (megabytes) / seconds;
        System.out.println("I was equal, even after " + totalbytes
                + " bytes and reading for " + dur
                + " ms (" + nf.format(rate) + "MB/sec * 2)" +
                " with a buffer size of " + myBufferSize / 1024 + " kB");
    }
}
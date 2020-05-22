import java.nio.ByteBuffer;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProducerFasterConsumerSlower {

  public static void main(String... args) {
    int procs = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newCachedThreadPool();//Executors.newFixedThreadPool(procs);

    Counter counter = new Counter();
    IndependentProducer producer = new IndependentProducer(executor, counter);
    AnotherConsumer consumer = new AnotherConsumer(producer.getOut(), counter);

    executor.execute(producer);
    executor.execute(consumer);

    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        producer.stop();
      }
    }, 1200L);
    //executor.shutdown(); // if shutdown no new tasks will be accepted (But we need to add more tasks).

  }

  public static String getRandomString(int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      char c = (char) (new Random().nextInt(25) + 'a');
      sb.append(c);
    }
    return sb.toString();
  }

  public static class IndependentProducer implements Runnable {

    private final BlockingQueue<byte[]> out;
    private ExecutorService executor;
    private Counter counter;
    private volatile boolean isRunning = false;

    public IndependentProducer(ExecutorService executor, Counter counter) {
      this.executor = executor;
      this.counter = counter;
      this.out = new LinkedBlockingQueue<>();
    }

    public IndependentProducer(ExecutorService executor, BlockingQueue<byte[]> out, Counter counter) {
      this.executor = executor;
      this.counter = counter;
      this.out = out;
    }

    @Override
    public void run() {
      int quantity = 0;
      isRunning = true;
      while (isRunning) {
        try {
          byte[] bytes = new byte[8];
          double value = Math.random();
          System.out.println("\t\tIndependentProducer -> " + value);
          ByteBuffer.wrap(bytes).putDouble(value);
          //bytes to be Write taken or Produced from some method!
          //out.put(bytes);
          Processor processor = new Processor(out, bytes);
          executor.execute(processor);
          Thread.sleep(100);
        } catch (Exception e) {
          //Handle Exceptions
          e.printStackTrace();
        }
        quantity++;
        counter.setValue(quantity);
      }
      System.out.println("\tSent:" + quantity);
    }

    public BlockingQueue<byte[]> getOut() {
      return out;
    }

    public void stop() {
      isRunning = false;
    }

  }

  public static class Processor implements Runnable {

    private final BlockingQueue<byte[]> in;
    private final byte[] inBytes;

    public Processor(BlockingQueue<byte[]> in, byte[] inBytes) {
      this.in = in;
      this.inBytes = inBytes;
    }

    @Override
    public void run() {
      if (inBytes != null) {
        try {
          System.out.println("\t\t\tProcessor -> " + inBytes);
          byte[] outBytes = internalProcessing(inBytes);
          in.put(outBytes);
        } catch (Exception e) {
          //Handle Exceptions
          e.printStackTrace();
        }
      }

    }
  }

  private static byte[] internalProcessing(byte[] in) {
    byte[] out = in;
    //Some task processing Input
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    return out;
  }

  public static class AnotherConsumer implements Runnable {

    private final BlockingQueue<byte[]> in;
    private Counter counter;
    private volatile boolean isRunning = false;

    public AnotherConsumer(Counter counter) {
      this.in = new LinkedBlockingQueue<>();
      this.counter = counter;
    }

    public AnotherConsumer(BlockingQueue<byte[]> in, Counter counter) {
      this.in = in;
      this.counter = counter;
    }

    @Override
    public void run() {
      int quantity = 0;
      isRunning = true;
      while (quantity == 0 || (quantity > 0 && quantity < counter.getValue())) {
        try {
          byte[] bytes = in.take();
          double value = ByteBuffer.wrap(bytes).getDouble();
          System.out.println("\t\tAnotherConsumer -> " + value);
          Thread.sleep(50);
        } catch (Exception e) {
          //Handle Exceptions
          e.printStackTrace();
        }
        quantity++;
      }
      System.out.println("\tRead:" + quantity);
    }

    public BlockingQueue<byte[]> getIn() {
      return in;
    }

    public void stop() {
      isRunning = false;
    }

  }

  public static class Counter {
    private final ReadWriteLock rwLock;
    private Integer value;

    public Counter() {
      this.value = 0;
      this.rwLock = new ReentrantReadWriteLock();
    }

    public Integer getValue() {
      Lock readLock = rwLock.readLock();
      readLock.lock();
      try {
        return value;
      } finally {
        readLock.unlock();
      }

    }

    public void setValue(Integer value) {
      Lock writeLock = rwLock.writeLock();
      writeLock.lock();
      try {
        this.value = value;
      } finally {
        writeLock.unlock();
      }
    }

  }

}
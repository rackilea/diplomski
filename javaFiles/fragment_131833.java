import java.util.Random;

public class TestThreads
{
    private DistanceSensor dist;
    private Thread distanceThread;
    public TestThreads()
    {
        this.dist = new DistanceSensor();
        this.distanceThread = new Thread(this.dist);
        this.distanceThread.start();
    }

    public int getDistance()
    {
        return this.dist.getMeasurement();
    }

    public void pauseDistanceSensor()
    {
      dist.setPaused(true);
    }

    public void resumeDistanceSensor()
    {
      dist.setPaused(false);
    }

    public void finish() {
      dist.setDone();
    }

    public static void main(String[] args)
    {
        TestThreads test = new TestThreads();
        long timestamp = System.currentTimeMillis();
        System.out.println("Starting at "+timestamp);
        System.out.println("1: "+test.getDistance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("2: "+test.getDistance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("waiting distance sensor and making 3 getDistance calls then sleeping main thread for 1 second - all 3 getDistance calls should be printed when the sleep ends");
        test.pauseDistanceSensor();
        System.out.println("3: "+test.getDistance());
        System.out.println("4: "+test.getDistance());
        System.out.println("5: "+test.getDistance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Alive! Notifying the thread");
        test.resumeDistanceSensor();
        System.out.println("Done at "+System.currentTimeMillis());
        test.finish();
    }
}

class DistanceSensor implements Runnable
{
    private final Random gen = new Random(54);
    private int currentVal;
    private boolean done = false, paused = false;
    public DistanceSensor()
    {
        this.currentVal = this.gen.nextInt(1500);
    }

    public void run()
    {
        while(!getDone()) {
          if(!getPaused()) synchronized(this) {this.currentVal = this.gen.nextInt(1500);}
          synchronized(this) {
            try {
              wait(500);
            } catch(InterruptedException ex) {
              ex.printStackTrace();
            }
          }
        }
    }

    public synchronized int getMeasurement()
    {
        return this.currentVal;
    }

    public synchronized boolean getPaused() {return paused;}
    public synchronized boolean getDone() {return done;}
    public synchronized void setPaused(boolean p) {paused = p;}
    public synchronized void setDone() {done = true;notify();}
}
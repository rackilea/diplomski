public class ThreadingExample {
    public static void main(String[] args) {
        final int numThread=4, chunkSize=10;
        int[] array=new int[numThread*chunkSize];
        Thread[] thread=new Thread[numThread];

        // create threads and define their jobs
        for(int t=0, p=0; t<numThread; t++, p+=chunkSize) {
            thread[t]=new Thread(new FillInJob(array, t, p, chunkSize));
        }

        // start the threads
        for(Thread t: thread) t.start();
        // now all running concurrently

        // wait for completion
        try {
            for(Thread t: thread) t.join();
        } catch(InterruptedException ex) {
            throw new AssertionError(ex);
        }

        // use result
        System.out.println(java.util.Arrays.toString(array));
    }
}
class FillInJob implements Runnable {
    private final int[] targetArray;
    private final int myID, startIndex, endIndex;

    FillInJob(int[] target, int id, int start, int size) {
      targetArray=target;
      myID=id;
      startIndex=start;
      endIndex=start+size;
    }

    public void run() {
        for(int ix=startIndex; ix<endIndex; ix++)
            targetArray[ix]=myID;
    }
}
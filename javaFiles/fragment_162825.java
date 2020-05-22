public static void main(String[] args) {
    int numberOfThreads  = ...
    for(int i = 0; i < numberOfThreads; i++) {
        File f1 = ...
        File f2 = .... 
        int j = ... 

        new Thread(new VectorClock(f1, f2, j)).start();
    }
}

public class VectorClock implements Runnable {
    public VectorClock(File file1, File file2, int i) {
       // ...
    }

    @Override
    public void run() {
        // this gets executed when invoked by a threads .start() routine
    }
}
public class ThreadSpawningPerformanceTest {
static long test(final int threadCount, final int workAmountPerThread) throws InterruptedException {
    Thread[] tt = new Thread[threadCount];
    final int[] aa = new int[tt.length];
    System.out.print("Creating "+tt.length+" Thread objects... ");
    long t0 = System.nanoTime(), t00 = t0;
    for (int i = 0; i < tt.length; i++) { 
        final int j = i;
        tt[i] = new Thread() {
            public void run() {
                int k = j;
                for (int l = 0; l < workAmountPerThread; l++) {
                    k += k*k+l;
                }
                aa[j] = k;
            }
        };
    }
    System.out.println(" Done in "+(System.nanoTime()-t0)*1E-6+" ms.");
    System.out.print("Starting "+tt.length+" threads with "+workAmountPerThread+" steps of work per thread... ");
    t0 = System.nanoTime();
    for (int i = 0; i < tt.length; i++) { 
        tt[i].start();
    }
    System.out.println(" Done in "+(System.nanoTime()-t0)*1E-6+" ms.");
    System.out.print("Joining "+tt.length+" threads... ");
    t0 = System.nanoTime();
    for (int i = 0; i < tt.length; i++) { 
        tt[i].join();
    }
    System.out.println(" Done in "+(System.nanoTime()-t0)*1E-6+" ms.");
    long totalTime = System.nanoTime()-t00;
    int checkSum = 0; //display checksum in order to give the JVM no chance to optimize out the contents of the run() method and possibly even thread creation
    for (int a : aa) {
        checkSum += a;
    }
    System.out.println("Checksum: "+checkSum);
    System.out.println("Total time: "+totalTime*1E-6+" ms");
    System.out.println();
    return totalTime;
}

public static void main(String[] kr) throws InterruptedException {
    int workAmount = 100000000;
    int[] threadCount = new int[]{1, 2, 10, 100, 1000, 10000, 100000};
    int trialCount = 2;
    long[][] time = new long[threadCount.length][trialCount];
    for (int j = 0; j < trialCount; j++) {
        for (int i = 0; i < threadCount.length; i++) {
            time[i][j] = test(threadCount[i], workAmount/threadCount[i]); 
        }
    }
    System.out.print("Number of threads ");
    for (long t : threadCount) {
        System.out.print("\t"+t);
    }
    System.out.println();
    for (int j = 0; j < trialCount; j++) {
        System.out.print((j+1)+". trial time (ms)");
        for (int i = 0; i < threadCount.length; i++) {
            System.out.print("\t"+Math.round(time[i][j]*1E-6));
        }
        System.out.println();
    }
}
}
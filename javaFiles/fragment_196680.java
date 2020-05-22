public class main {

    static boolean found;
    static final Object lock = new Object();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int threadCount = 4; //amount of threads to use
        Random rand = new Random();
        Searcher[] s_arr = new Searcher[threadCount]; //array of threads


        int[] arr = new int[10000]; //array to search through
        for (int i = 0; i < arr.length; i++) //randomizing #'s in array
            arr[i] = (int) (rand.nextFloat() * 1000);

        int randIndex = rand.nextInt(arr.length); //choose random index

        arr[randIndex] = -1; //set random index to = -1

        for (int i = 0; i < threadCount; i++) { //
            s_arr[i] = new Searcher(Arrays.copyOfRange(arr, i * (arr.length/threadCount), (i+1) * (arr.length/threadCount)),
                    (int) (i), i); //assign subarray for this thread to search through
            System.out.println(s_arr[i].wait);
            s_arr[i].start();
        }

        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("found!");

        for (int i = 0; i < threadCount; i++) {
            try {
                s_arr[i].join(); //wait for the threads in order before continuing
                System.out.println("Thread ["+i+"] completed");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("All threads stopped, program complete.");
    }

}

class Searcher extends Thread {

    int[] arr;
    int wait;
    int index;

    public Searcher(int[] arr, int wait, int i) {
        this.arr = arr;
        this.wait = wait;
        this.index = i;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                System.out.println("["+index+"] -1 Found at index: "+i);
                main.found = true;
                synchronized (main.lock) {
                    main.lock.notify();
                }
                break;
            }
            if (main.found) break;
            //purposely slow down this thread
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("["+index+"] has stopped");

    }

}
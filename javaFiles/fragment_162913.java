class Problem {
    private static final int MY_THREADS = 10;
    private static final double[] maximums = new double[3];


    public static void main(String[] args) {
        double[] array = {...};

        for ( int i = 0; i < maximums.length; ++i) {
            maximums[i] = Double.MIN_VALUE; //Remember that this won't work with negative values in array
        }

        ExecutorService executor = Executors.newFixedThreadPool(MY_THREADS);

        int start = 0;
        int length = array.length/MY_THREADS;
        for( int i = 0; i < MY_THREADS; i++ )
        {
            //You probably want to give it only part of array to consider,
            //otherwise you are wasting resources and might even try to insert same element more than once.
            Runnable worker = new MyRunnable(Arrays.copyOfRange( array, start, start + length ) );
            executor.execute(worker);
            start += length;
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        System.out.println( Arrays.toString( maximums ));
    }

    //This is unsynchronized - but with this problem - it will at worst cause unnecessary insert attempt.
    private static int getMinIndex() {
        int minIndex = -1;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < maximums.length; ++i) {
            if (maximums[i] < min) {
                min = maximums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //You have to synchronize the insertion somehow,
    // otherwise you might insert two values into same spot losing one of max.
    private static synchronized void insertIntoMaximum( double k ){
        int minIndex = getMinIndex();
        if( maximums[minIndex] < k ){
            maximums[minIndex] = k;
        }
    }

    public static class MyRunnable implements Runnable {
        private double[] array;

        //Since its inner class, I didn't think passing maximums into it was necessary.
        // You could pass it here, but you would still probably need to call parent for insertion.
        MyRunnable(double[] array) {
            this.array = array;
        }

        @Override
        public void run() {

            //this while was an interesting attempt at making indexed for, that doesn't even need to be indexed.
            for( double v : array )
            {
                if( v > maximums[getMinIndex()] )
                {
                    insertIntoMaximum( v );
                }
            }
        }
    }
}
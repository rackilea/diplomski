final CountDownLatch cdl = new CountDownLatch( 1 );
            final Thread t = new Thread( new Runnable() {
                public void run() {
                    quicksort(a, i+1, r );
                    cdl.countDown();
                }
            } };
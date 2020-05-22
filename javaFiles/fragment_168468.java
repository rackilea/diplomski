@Test
    public void test() throws Exception {

        ThreadCoordinator tc = ThreadCoordinator.getInstance();

        for( int i = 0; i < 100; i++ ) {
            MyThread r = new MyThread();
            r.run();

            // This will block until the Thread has called release (after setting its identity on the ThreadCoordinator)    
            tc.acquire();
            String newThreadIdentity = tc.getIdentity();
            System.out.println( "Received the new thread's identity:         " + newThreadIdentity );

            // This will allow the next Thread to acquire the semaphore
            tc.release();
        }
    }


    class MyThread extends Thread {

        public void run() {
            String identity = Integer.toString( (int)(Math.random() * 10000) );
            System.out.println( "Running a new thread with identity:         " + identity );

            // Get a reference to the singleton
            ThreadCoordinator tc = ThreadCoordinator.getInstance();
            try {
                tc.acquire();
                tc.setIdentity( identity );
                System.out.println( "Notified the ThreadCoordinator from thread: " + identity );
                tc.release();
            } catch( InterruptedException e ) {
                System.out.println( "Caught an interrupted exception: " + e );
            }

        }

    }
}
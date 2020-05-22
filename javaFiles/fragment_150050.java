private static void threadedWriteLock(){
    final ThreadSafeArrayList<String> list = getList();

    Thread threadOne;
    Thread threadTwo;
    final long lStartMS = System.currentTimeMillis();

    list.add("String 1");
    list.add("String 2");

    System.out.println("******* basic write lock test *******");

    threadOne = new Thread(new Runnable(){
        public void run(){
            try {
                list.lockWrite();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                list.unlockWrite();
            }
        }
    });

    threadTwo = new Thread(new Runnable(){
        public void run(){
            //give threadOne time to lock (just in case)
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Expect a wait....");

            //if this "add" line is commented out, even the iterator read will be locked. 
            //So its not only locking on the add, but also the read which is correct.
            list.add("String 3"); 

            for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
                 System.out.println("String at index " + it.nextIndex() + ": " + it.next());
            }

            System.out.println("ThreadTwo completed in " + (System.currentTimeMillis() - lStartMS) + "ms");

        }
    });

    threadOne.start();
    threadTwo.start();
}

private static void threadedReadLock(){
    final ThreadSafeArrayList<String> list = getList();

    Thread threadOne;
    Thread threadTwo;
    final long lStartMS = System.currentTimeMillis();

    list.add("String 1");
    list.add("String 2");

    System.out.println("******* basic read lock test *******");

    threadOne = new Thread(new Runnable(){
        public void run(){
            try {
                list.lockRead();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                list.unlockRead();
            }
        }
    });

    threadTwo = new Thread(new Runnable(){
        public void run(){
            //give threadOne time to lock (just in case)
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Expect a wait if adding, but not reading....");

            //if this "add" line is commented out, the read will continue without holding up the thread
            list.add("String 3"); 

            for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
                 System.out.println("String at index " + it.nextIndex() + ": " + it.next());
            }

            System.out.println("ThreadTwo completed in " + (System.currentTimeMillis() - lStartMS) + "ms");

        }
    });

    threadOne.start();
    threadTwo.start();
}
Thread t1 = new Thread(runnable);
Thread t2 = new Thread(runnable);
Thread t3 = new Thread(runnable);
t1.setName("Ben");
t2.setName("Rish");
t3.setName("Mom");
t1.start();
t2.start();
t3.start();

Thread.sleep(1000); //make the main thread to sleep for a sec

//time to interrupt t1 !!!!
t1.interrupt();   //throws Interrupted exception in the run method of Thread t1
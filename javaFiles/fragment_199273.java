Worker w1 = new Worker(..list of 500 files...) ; // First List
Worker w2 = new Worker(..list of the other 500 files...) ;  // Second List
Thread t1 = new Thread(w1,"thread1");
Thread t2 = new Thread(w2,"thread2");

t1.start();
t2.start();
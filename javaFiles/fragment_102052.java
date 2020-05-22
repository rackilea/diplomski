A a = new A();
Thread thread = new Thread(a);
// start the thread which calls run()
thread.start();
// wait for the thread to finish
thread.join();
System.out.println(a.i);
A a = new A();
// start the thread which calls run()
a.start();
// wait for the thread to finish
a.join();
System.out.println(a.i);
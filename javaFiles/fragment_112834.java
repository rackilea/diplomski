Thread t = new Thread(new ThreadDemo());
// this will call run() function
t.start();
// waits for this thread to die
t.join();
System.out.println("Hello");
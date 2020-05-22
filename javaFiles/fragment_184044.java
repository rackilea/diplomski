System.out.println("Thread: " + Thread.currentThread());
Thread thread = new Thread(() -> {
      System.out.println("Thread: " + Thread.currentThread());
      updateData();
      updateSwingGUI();
   }).start();

System.out.println("I'm on the old thread, can do something in parallel.");

thread.join();
System.out.println("Second thread finished updating GUI.");
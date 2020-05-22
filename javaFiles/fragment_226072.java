thread.start();                           
    try {
      System.out.println("Main thread waiting for new thread to finish");
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
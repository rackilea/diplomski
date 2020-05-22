public void run() {
  while (done == false) { // 'done' should be volatile
    try {
      // you don't need to be in a synchronized block to read
      String msg = GUI.getVal(); 
      System.out.println("Reporting value of strX from PeekAtGUI: " + msg);
      // but you do need lock before you can wait. 
      // It's unusual to lock a class externally in this way, instead
      // one might provide a GUI.waitForNextVal() method.
      synchronized(GUI.class) {
        GUI.class.wait();
      }
    } catch (InterruptedException e) {e.printStackTrace();}
  }
}
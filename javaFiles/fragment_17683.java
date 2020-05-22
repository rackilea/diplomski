class MyLocalThread extends Thread { 
    public void run() { 
      if(!Thread.interrupted()) {
        try {
        //do some work
       }
        catch (InterruptedException e) { 
            System.out.println("InterruptedException occur"); 
        } 
      }
    } 
}
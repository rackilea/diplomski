try { 
    thread.join(); 
} catch (InterruptedException e) { 
    // TODO Auto-generated catch block 
    System.err.println("Exception In Pause"+ e);
    e.printStackTrace(); 
}
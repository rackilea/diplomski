class MainThread$MyRunnable implements java.lang.Runnable {
  MainThread$MyRunnable(int);
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0       
       5: iload_1       
       6: putfield      #2                  // Field data:I
       9: return        

  public void run();
    Code:
       0: aload_0       
       1: getfield      #2                  // Field data:I
       4: invokestatic  #3                  // Method MainThread.printData:(I)V
       7: return        
}
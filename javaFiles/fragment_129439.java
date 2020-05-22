MainThread$1(int);
    Code:
       0: aload_0       
       1: iload_1       
       2: putfield      #1                  // Field val$data:I
       5: aload_0       
       6: invokespecial #2                  // Method java/lang/Object."<init>":()V
       9: return        

  public void run();
    Code:
       0: aload_0       
       1: getfield      #1                  // Field val$data:I
       4: invokestatic  #3                  // Method MainThread.printData:(I)V
       7: return
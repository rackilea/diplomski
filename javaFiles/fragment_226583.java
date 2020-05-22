public class SingleTonBillPaugh {
  public static SingleTonBillPaugh getInstance();
    Code:
       0: invokestatic  #2                  // Method SingleTonBillPaugh$SingleTonHelper.access$000:()LSingleTonBillPaugh;
       3: areturn

  private SingleTonBillPaugh();
    Code:
       0: aload_0
       1: invokespecial #3                  // Method java/lang/Object."<init>":()V
       4: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
       7: new           #5                  // class java/lang/StringBuilder
      10: dup
      11: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
      14: invokestatic  #7                  // Method java/lang/Thread.currentThread:()Ljava/lang/Thread;
      17: invokevirtual #8                  // Method java/lang/Thread.getName:()Ljava/lang/String;
      20: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      23: ldc           #10                 // String  instance is going to be created
      25: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      28: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      31: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      34: return

  SingleTonBillPaugh(SingleTonBillPaugh$1);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method "<init>":()V
       4: return
}
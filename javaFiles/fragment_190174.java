class SafePublication$1 implements java.lang.Runnable {
  final Unsafe val$unsafe;

  final SafePublication this$0;

  SafePublication$1(SafePublication, Unsafe);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #1                  // Field this$0:LSafePublication;
       5: aload_0
       6: aload_2
       7: putfield      #2                  // Field val$unsafe:LUnsafe;
      10: aload_0
      11: invokespecial #3                  // Method java/lang/Object."<init>":()V
      14: return

  public void run();
    Code:
       0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: aload_0
       4: getfield      #2                  // Field val$unsafe:LUnsafe;
       7: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      10: return
}
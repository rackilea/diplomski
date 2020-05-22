...

  final int CONSTANT_NUMBER;
    descriptor: I
    flags: ACC_FINAL

  public text.ConstantCheck();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: ldc           #2                  // String Foo Bar
         7: invokevirtual #3                  // Method java/lang/String.length:()I
        10: putfield      #4                  // Field CONSTANT_NUMBER:I
        13: return
...
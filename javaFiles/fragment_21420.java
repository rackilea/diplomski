...

  final int CONSTANT_NUMBER;
    descriptor: I
    flags: ACC_FINAL
    ConstantValue: int 7

  public text.ConstantCheck();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: bipush        7
         7: putfield      #2                  // Field CONSTANT_NUMBER:I
        10: return
    ....
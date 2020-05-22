// access flags 0x9
  public static main([Ljava/lang/String;)V
    TRYCATCHBLOCK L0 L1 L1 null
    TRYCATCHBLOCK L2 L3 L1 null
   L0
    LINENUMBER 4 L0
    INVOKESTATIC JSRDemo.bodyOfTry ()V
   L4
    LINENUMBER 5 L4
    GOTO L2
   L1
    LINENUMBER 6 L1
    ASTORE 2
    JSR L5               // JSR jumps to the finally block
   L6
    LINENUMBER 8 L6
    ALOAD 2
    ATHROW
   L5
    LINENUMBER 6 L5
    ASTORE 1
   L7
    LINENUMBER 7 L7
    INVOKESTATIC JSRDemo.bodyOfFinally ()V
   L8
    LINENUMBER 8 L8
    RET 1                 // RET returns from the finally block
   L2
    JSR L5                // Jump to the same finally block from another execution path
   L3
    LINENUMBER 9 L3
    RETURN
   L9
    LOCALVARIABLE args [Ljava/lang/String; L0 L9 0
    MAXSTACK = 1
    MAXLOCALS = 3
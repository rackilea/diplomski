// access flags 0x0
  test(LTest;)I
   L0
    LINENUMBER 5 L0

    // load t
    ALOAD 1

    // if (t == null) throw new NullPointerException(); compressed in only two instructions
    INVOKEVIRTUAL java/lang/Object.getClass ()Ljava/lang/Class;
    POP

    // the actual value of myFinalField
    ICONST_1

    IRETURN
   L1
    LOCALVARIABLE this LTest; L0 L1 0
    LOCALVARIABLE t LTest; L0 L1 1
    MAXSTACK = 1
    MAXLOCALS = 2
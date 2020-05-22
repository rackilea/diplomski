public doSomething(I)I
   L0
    LINENUMBER 38 L0
    ALOAD 0
    ILOAD 1
    INVOKEVIRTUAL TestRunner.otherMethod (I)V
   L1
    LINENUMBER 39 L1
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "otherMethod is complete."
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
   L2
    LINENUMBER 40 L2
    ICONST_0
    IRETURN
   L3
    LOCALVARIABLE this LTestRunner; L0 L3 0
    LOCALVARIABLE x I L0 L3 1
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public otherMethod(I)V
   L0
    LINENUMBER 46 L0
    RETURN <-- return inserted!
   L1
    LOCALVARIABLE this LTestRunner; L0 L1 0
    LOCALVARIABLE y I L0 L1 1
    MAXSTACK = 0
    MAXLOCALS = 2
}
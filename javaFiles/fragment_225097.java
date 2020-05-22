static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=3, locals=0, args_size=0
         0: new           #1                  // class test7/Example
         3: dup
         4: ldc           #13                 // String __EX_1__
         6: invokespecial #15                 // Method "<init>":(Ljava/lang/String;)V
         9: putstatic     #19                 // Field ex1:Ltest7/Example;
        12: ldc           #21                 // String Paulo
        14: putstatic     #23                 // Field DEFAULT_NAME:Ljava/lang/String;
        17: getstatic     #25                 // Field java/lang/System.out:Ljava/io/PrintStream;
        20: ldc           #31                 // String Class inited
        22: invokevirtual #33                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        25: return
      LineNumberTable:
        line 4: 0
        line 5: 12
        line 10: 17
        line 11: 25
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
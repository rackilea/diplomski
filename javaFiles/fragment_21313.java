public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #25                 // Field java/lang/System.out:Ljav
a/io/PrintStream;
         3: iconst_5 -->                      // No "x" but a constant value instead of "x"
         4: invokevirtual #31                 // Method java/io/PrintStream.prin
tln:(I)V
         7: getstatic     #25                 // Field java/lang/System.out:Ljav
a/io/PrintStream;
        10: getstatic     #20                 // Field y:I --> but "y" is being fetched
        13: invokevirtual #31                 // Method java/io/PrintStream.prin
tln:(I)V
        16: return
      LineNumberTable:
        line 13: 0
        line 14: 7
        line 15: 16
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      17     0  args   [Ljava/lang/String;
}
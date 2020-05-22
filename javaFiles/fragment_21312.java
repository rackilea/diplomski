ublic Sample();
   descriptor: ()V
   flags: ACC_PUBLIC
   Code:
     stack=2, locals=2, args_size=1
        0: aload_0
        1: invokespecial #24                 // Method java/lang/Object."<init>
:()V 
        4: iconst_5       ------->           // Here 5 is used directly as it is a compile time constant
        5: getstatic     #20   ------->      // Field y:I
        8: iadd
        9: istore_1
       10: getstatic     #25                 // Field java/lang/System.out:Ljav
/io/PrintStream;
       13: iload_1
       14: invokevirtual #31                 // Method java/io/PrintStream.prin
ln:(I)V
       17: return
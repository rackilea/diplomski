public static void main(java.lang.String[]);
Code:
      0: new           #21                 // class java/lang/String
      3: dup
      4: ldc           #23                 // String APPLES
      6: invokespecial #25                 // Method java/lang/String."<init>":
Ljava/lang/String;)V
      9: astore_1
     10: new           #21                 // class java/lang/String
     13: dup
     14: ldc           #23                 // String APPLES
     16: invokespecial #25                 // Method java/lang/String."<init>":
Ljava/lang/String;)V
     19: astore_2
     20: getstatic     #28                 // Field java/lang/System.out:Ljava/
o/PrintStream;
     23: invokevirtual #34                 // Method java/io/PrintStream.printl
:()V
     26: return
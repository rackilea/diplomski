$ javac TryBlock.java; javap -c TryBlock
Compiled from "TryBlock.java"
class TryBlock {
  TryBlock();
    Code:
       0: aload_0
       // Method java/lang/Object."<init>":()V
       1: invokespecial #1                  
       4: return

  public static void main(java.lang.String[]);
    Code:
       // Method a:()Z
       0: invokestatic  #2                  
       3: pop
       // Method b:()Z
       4: invokestatic  #3                  
       7: pop
       8: return

  public static boolean a();
    Code:
       // Field java/lang/System.out:Ljava/io/PrintStream;
       0: getstatic     #4                  
       // String A
       3: ldc           #5                  
       // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       5: invokevirtual #6                  
       8: iconst_1
       9: ireturn
      10: astore_0
      11: iconst_0
      12: ireturn
    Exception table:
       from    to  target type
           0     9    10   Class java/lang/Exception

  public static boolean b();
    Code:
       // Field java/lang/System.out:Ljava/io/PrintStream;
       0: getstatic     #4                  
       // String B
       3: ldc           #8                  
       // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       5: invokevirtual #6                  
       8: goto          14
      11: astore_0
      12: iconst_0
      13: ireturn
      14: iconst_1
      15: ireturn
    Exception table:
       from    to  target type
           0     8    11   Class java/lang/Exception
}
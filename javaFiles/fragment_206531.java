Compiled from "Test.java"
public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello before method
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: invokestatic  #5                  // Method publicMethod:()V
      11: invokestatic  #6                  // Method privateMethod:()V
      14: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      17: ldc           #7                  // String Hello after method
      19: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      22: return

  public static void publicMethod();
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #8                  // String The public method
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return

  private static void privateMethod();
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #9                  // String The private method
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
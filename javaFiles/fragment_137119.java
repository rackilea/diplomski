// Source code
public class Test {
    public static void main(String [] args) {
        int value = 4000;
        System.out.println(value);

        System.out.println(5678);
    }
}

// Byte code
public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1    // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: sipush        4000
       3: istore_1
       4: getstatic     #2    // Field java/lang/System.out:Ljava/io/PrintStream;
       7: iload_1
       8: invokevirtual #3    // Method java/io/PrintStream.println:(I)V
      11: getstatic     #2    // Field java/lang/System.out:Ljava/io/PrintStream;
      14: sipush        5678
      17: invokevirtual #3    // Method java/io/PrintStream.println:(I)V
      20: return
}
// Source code
public class Test {
    public static void main(String [] args) {
        int value = (int) System.currentTimeMillis();
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
       0: invokestatic  #2    // Method java/lang/System.currentTimeMillis:()J
       3: l2i
       4: istore_1
       5: getstatic     #3    // Field java/lang/System.out:Ljava/io/PrintStream;
       8: iload_1
       9: invokevirtual #4    // Method java/io/PrintStream.println:(I)V
      12: getstatic     #3    // Field java/lang/System.out:Ljava/io/PrintStream;
      15: sipush        5678
      18: invokevirtual #4    // Method java/io/PrintStream.println:(I)V
      21: return
}
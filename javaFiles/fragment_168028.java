Compiled from "Test.java"
public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_5
       1: istore_1
       2: iload_1
       3: iconst_2
       4: if_icmple     28
       7: iload_1
       8: bipush        6
      10: if_icmplt     18
      13: iload_1
      14: iconst_4
      15: if_icmpge     28
      18: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: iconst_1
      22: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
      25: goto          35
      28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      31: iconst_0
      32: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
      35: return
}
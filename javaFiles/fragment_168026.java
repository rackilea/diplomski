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
       2: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       5: iload_1
       6: iconst_2
       7: if_icmple     25
      10: iload_1
      11: bipush        6
      13: if_icmplt     21
      16: iload_1
      17: iconst_4
      18: if_icmpge     25
      21: iconst_1
      22: goto          26
      25: iconst_0
      26: invokevirtual #3                  // Method java/io/PrintStream.println:(Z)V
      29: return
}
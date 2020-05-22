> javac *.java && javap -c *.class
Compiled from "Test.java"
public class Test {
  public Test();
  Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String...);
  Code:
       0: iconst_1
       1: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       4: astore_1
       5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       8: aload_1
       9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      12: return
}
Compiled from "Test2.java"
public class Test2 {
  public Test2();
  Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String...);
  Code:
       0: iconst_1
       1: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       4: astore_1
       5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       8: aload_1
       9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      12: return
}
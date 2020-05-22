javap -c Test
Compiled from "Test.java"
public class Test extends java.lang.Object{
    public Test();
    Code:
    0:  aload_0
    1:  invokespecial   #1; //Method java/lang/Object."<init>":()V
    4:  return

    public static void main(java.lang.String[]);
    Code:
    0:  getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
    3:  getstatic   #3; //Field value:Ljava/lang/String;
    6:  invokevirtual   #4; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
    9:  return

    static {};
    Code:
    0:  getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
    3:  ldc #5; //String Test static
    5:  invokevirtual   #4; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
    8:  ldc #6; //String test value
    10: putstatic   #3; //Field value:Ljava/lang/String;
    13: return

}
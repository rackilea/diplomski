javap -c Test
Compiled from "Test.java"
public class Test extends java.lang.Object{
    public Test();
    Code:
    0:  aload_0
    1:  invokespecial   #11; //Method java/lang/Object."<init>":()V
    4:  return

    public static void main(java.lang.String[]);
    Code:
    0:  getstatic   #21; //Field java/lang/System.out:Ljava/io/PrintStream;
    3:  getstatic   #23; //Field value:Ljava/lang/String;
    6:  invokevirtual   #29; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
    9:  return

}
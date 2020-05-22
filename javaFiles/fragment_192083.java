> javap -classpath target\test-classes -c RefTest

Compiled from "RefTest.java"
public class RefTest extends java.lang.Object{
public RefTest();
  Code:
   0:   aload_0
   1:   invokespecial   #8; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   aconst_null
   1:   astore_1
   2:   aconst_null
   3:   astore_2
   4:   getstatic       #17; //Field java/lang/System.out:Ljava/io/PrintStream;
   7:   aload_1
   8:   invokevirtual   #23; //Method java/lang/Object.toString:()Ljava/lang/String;
   11:  invokevirtual   #27; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   14:  getstatic       #17; //Field java/lang/System.out:Ljava/io/PrintStream;
   17:  aload_2
   18:  invokevirtual   #33; //Method java/io/PrintStream.print:(Ljava/lang/Object;)V
   21:  return

}
$ javap -c OuterClass
Compiled from "OuterClass.java"
public class OuterClass extends java.lang.Object{
public OuterClass();
  Code:
   0: aload_0
   1: invokespecial #1; //Method java/lang/Object."<init>":()V
   4: return

public static void main(java.lang.String[]);
  Code:
   0: bipush 7
   2: invokestatic #2; //Method OuterClass$InnerClass.access$002:(I)I
   5: pop
   6: getstatic #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   9: invokestatic #4; //Method OuterClass$InnerClass.access$000:()I
   12: invokevirtual #5; //Method java/io/PrintStream.println:(I)V
   15: return

}
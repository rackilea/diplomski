Compiled from "OuterClass.java"
public class OuterClass extends java.lang.Object{
public OuterClass();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public void instantiate();
  Code:
   0:   new     #2; //class OuterClass$PrivateInnerClass
   3:   dup
   4:   aload_0
   5:   aconst_null
   6:   invokespecial #3; //Method OuterClass$PrivateInnerClass."<init>":
                          //(LOuterClass;LOuterClass$1;)V
   9:   pop
   10:  return

}
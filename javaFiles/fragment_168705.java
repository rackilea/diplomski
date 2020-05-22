$ javap -c Test
Compiled from "Test.java"
class Test extends java.lang.Object{
Test();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

void equals(boolean);
  Code:
   0:   iload_1
   1:   ifne    4
   4:   return

void not(boolean);
  Code:
   0:   iload_1
   1:   ifne    4
   4:   return

}
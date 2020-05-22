$ javap -classpath target/classes/ -c -l test.Test
Compiled from "this.file.does.not.exist.txt"
public class test.Test extends java.lang.Object{
public static void main(java.lang.String[]);
  Code:
   0:   new #9; //class java/lang/RuntimeException
   3:   dup
   4:   invokespecial   #13; //Method java/lang/RuntimeException."<init>":()V
   7:   athrow
   8:   return

  LineNumberTable: 
   line 123: 0
}
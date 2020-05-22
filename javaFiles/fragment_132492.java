Classfile /C:/Users/jbosboom/Documents/stackoverflow/build/classes/Main.class
  Last modified Jul 2, 2014; size 346 bytes
  MD5 checksum 2237cda2a15a58382b0fb98d6afacc7e
  Compiled from "Main.java"
public class Main
  SourceFile: "Main.java"
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #3.#17         //  java/lang/Object."<init>":()V
   #2 = Class              #18            //  Main
   #3 = Class              #19            //  java/lang/Object
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               LMain;
  #11 = Utf8               identity
  #12 = Utf8               (LFoo;)Ljava/lang/Object;
  #13 = Utf8               x
  #14 = Utf8               LAAA;
  #15 = Utf8               SourceFile
  #16 = Utf8               Main.java
  #17 = NameAndType        #4:#5          //  "<init>":()V
  #18 = Utf8               Main
  #19 = Utf8               java/lang/Object
  #20 = Utf8               java/lang/Thread
  #21 = Class              #20            //  java/lang/Thread
  #21 = Utf8               (LBar;)LFakename;
{
  public Main();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 6: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LMain;

  public static java.lang.Object identity(Foo);
    descriptor: (LFoo;)Ljava/lang/Object;
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: areturn
      LineNumberTable:
        line 11: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       2     0     x   LAAA;
}
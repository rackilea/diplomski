C:>more > S.java
class S {
  Object  hello(int i, double d, long j, Thread t ) {
   return new Object();
  }
}
^C
C:>javac S.java

C:>javap -verbose S
class S extends java.lang.Object
  SourceFile: "S.java"
  minor version: 0
  major version: 50
  Constant pool:
const #1 = Method       #2.#12; //  java/lang/Object."<init>":()V
const #2 = class        #13;    //  java/lang/Object
const #3 = class        #14;    //  S
const #4 = Asciz        <init>;
const #5 = Asciz        ()V;
const #6 = Asciz        Code;
const #7 = Asciz        LineNumberTable;
const #8 = Asciz        hello;
const #9 = Asciz        (IDJLjava/lang/Thread;)Ljava/lang/Object;;
const #10 = Asciz       SourceFile;
const #11 = Asciz       S.java;
const #12 = NameAndType #4:#5;//  "<init>":()V
const #13 = Asciz       java/lang/Object;
const #14 = Asciz       S;

{
S();
  Code:
   Stack=1, Locals=1, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return
  LineNumberTable:
   line 1: 0


java.lang.Object hello(int, double, long, java.lang.Thread);
  Code:
   Stack=2, Locals=7, Args_size=5
   0:   new     #2; //class java/lang/Object
   3:   dup
   4:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   7:   areturn
  LineNumberTable:
   line 3: 0


}
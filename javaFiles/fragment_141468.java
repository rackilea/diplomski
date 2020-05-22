Classfile /.../String1.class
  Last modified 02/05/2013; size 458 bytes
  MD5 checksum e3c355bf648c7441784ffc6b9765ba4d
  Compiled from "String1.java"
public class String1
  SourceFile: "String1.java"
  minor version: 0
  major version: 51
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #8.#17         //  java/lang/Object."<init>":()V
   #2 = Class              #18            //  java/lang/String
   #3 = String             #19            //  Hello
   #4 = Methodref          #2.#20         //  java/lang/String."<init>":(Ljava/l
ang/String;)V
   #5 = Fieldref           #21.#22        //  java/lang/System.out:Ljava/io/Prin
tStream;
   #6 = Methodref          #23.#24        //  java/io/PrintStream.println:(Ljava
/lang/String;)V
   #7 = Class              #25            //  String1
   #8 = Class              #26            //  java/lang/Object
   #9 = Utf8               <init>
  #10 = Utf8               ()V
  #11 = Utf8               Code
  #12 = Utf8               LineNumberTable
  #13 = Utf8               main
  #14 = Utf8               ([Ljava/lang/String;)V
  #15 = Utf8               SourceFile
  #16 = Utf8               String1.java
  #17 = NameAndType        #9:#10         //  "<init>":()V
  #18 = Utf8               java/lang/String
  #19 = Utf8               Hello
  #20 = NameAndType        #9:#27         //  "<init>":(Ljava/lang/String;)V
  #21 = Class              #28            //  java/lang/System
  #22 = NameAndType        #29:#30        //  out:Ljava/io/PrintStream;
  #23 = Class              #31            //  java/io/PrintStream
  #24 = NameAndType        #32:#27        //  println:(Ljava/lang/String;)V
  #25 = Utf8               String1
  #26 = Utf8               java/lang/Object
  #27 = Utf8               (Ljava/lang/String;)V
  #28 = Utf8               java/lang/System
  #29 = Utf8               out
  #30 = Utf8               Ljava/io/PrintStream;
  #31 = Utf8               java/io/PrintStream
  #32 = Utf8               println
{
  public String1();
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>
":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=2, args_size=1
         0: new           #2                  // class java/lang/String
         3: dup
         4: ldc           #3                  // String Hello
         6: invokespecial #4                  // Method java/lang/String."<init>
":(Ljava/lang/String;)V
         9: astore_1
        10: getstatic     #5                  // Field java/lang/System.out:Ljav
a/io/PrintStream;
        13: aload_1
        14: invokevirtual #6                  // Method java/io/PrintStream.prin
tln:(Ljava/lang/String;)V
        17: return
      LineNumberTable:
        line 3: 0
        line 4: 10
        line 5: 17
}
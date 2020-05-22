Classfile /C:/development/testProject/test/Test1.class
Last modified 29/Nov/2012; size 612 bytes
MD5 checksum 858c009090bfb57d704b2eaf91c2cb75
Compiled from "Test1.java"
public class test.Test1
SourceFile: "Test1.java"
Synthetic: true
minor version: 0
major version: 50
flags: ACC_PUBLIC, ACC_SUPER

Constant pool:
#1 = Class              #2             //  test/Test1
#2 = Utf8               test/Test1
#3 = Class              #4             //  java/lang/Object
#4 = Utf8               java/lang/Object
#5 = Utf8               <init>
#6 = Utf8               ()V
#7 = Utf8               Code
#8 = Methodref          #3.#9          //  java/lang/Object."<init>":()V
#9 = NameAndType        #5:#6          //  "<init>":()V
#10 = Utf8               LineNumberTable
#11 = Utf8               LocalVariableTable
#12 = Utf8               this
#13 = Utf8               Ltest/Test1;
#14 = Utf8               SourceFile
#15 = Utf8               Test1.java
#16 = Utf8               someInjectedMethod
#17 = Utf8               java/lang/System
#18 = Class              #17            //  java/lang/System
#19 = Utf8               out
#20 = Utf8               Ljava/io/PrintStream;
#21 = NameAndType        #19:#20        //  out:Ljava/io/PrintStream;
#22 = Fieldref           #18.#21        //  java/lang/System.out:Ljava/io/PrintStream;
#23 = Utf8               injection example
#24 = String             #23            //  injection example
#25 = Utf8               java/io/PrintStream
#26 = Class              #25            //  java/io/PrintStream
#27 = Utf8               println
#28 = Utf8               (Ljava/lang/String;)V
#29 = NameAndType        #27:#28        //  println:(Ljava/lang/String;)V
#30 = Methodref          #26.#29        //  java/io/PrintStream.println:(Ljava/lang/String;)V
#31 = Utf8               RuntimeVisibleAnnotations
#32 = Utf8               Ltest/TestAnnotationToShowItInConstantTable;
#33 = Utf8               Synthetic
{
public com.qubit.augmentation.test.Test1();
Signature: ()V
flags: ACC_PUBLIC

Code:
  stack=1, locals=1, args_size=1
     0: aload_0       
     1: invokespecial #8                  // Method java/lang/Object."<init>":()V
     4: return        
  LineNumberTable:
    line 3: 0
  LocalVariableTable:
    Start  Length  Slot  Name   Signature
           0       5     0  this   Ltest/Test1;

protected void someInjectedMethod();
Signature: ()V
flags: ACC_PROTECTED

Code:
  stack=2, locals=1, args_size=1
     0: getstatic     #22                 // Field java/lang/System.out:Ljava/io/PrintStream;
     3: ldc           #24                 // String injection example
     5: invokevirtual #30                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     8: return        
RuntimeVisibleAnnotations:
  0: #32()
Synthetic: true
}
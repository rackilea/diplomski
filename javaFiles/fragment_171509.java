Classfile LambdaCode.class
  Last modified 30.05.2013; size 771 bytes
  MD5 checksum 79bf2821b5a14485934e5cebb60c99d6
  Compiled from "LambdaCode.java"
public class test.lambda.LambdaCode
  SourceFile: "LambdaCode.java"
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #11.#22        //  java/lang/Object."<init>":()V
   #2 = Class              #23            //  java/lang/String
   #3 = String             #24            //  hello
   #4 = Methodref          #25.#26        //  java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
   #5 = InterfaceMethodref #27.#28        //  java/util/List.iterator:()Ljava/util/Iterator;
   #6 = InterfaceMethodref #29.#30        //  java/util/Iterator.hasNext:()Z
   #7 = InterfaceMethodref #29.#31        //  java/util/Iterator.next:()Ljava/lang/Object;
   #8 = Fieldref           #32.#33        //  java/lang/System.out:Ljava/io/PrintStream;
   #9 = Methodref          #34.#35        //  java/io/PrintStream.println:(Ljava/lang/String;)V
  #10 = Class              #36            //  test/lambda/LambdaCode
  #11 = Class              #37            //  java/lang/Object
  #12 = Utf8               <init>
  #13 = Utf8               ()V
  #14 = Utf8               Code
  #15 = Utf8               LineNumberTable
  #16 = Utf8               main
  #17 = Utf8               ([Ljava/lang/String;)V
  #18 = Utf8               StackMapTable
  #19 = Class              #38            //  java/util/Iterator
  #20 = Utf8               SourceFile
  #21 = Utf8               LambdaCode.java
  #22 = NameAndType        #12:#13        //  "<init>":()V
  #23 = Utf8               java/lang/String
  #24 = Utf8               hello
  #25 = Class              #39            //  java/util/Arrays
  #26 = NameAndType        #40:#41        //  asList:([Ljava/lang/Object;)Ljava/util/List;
  #27 = Class              #42            //  java/util/List
  #28 = NameAndType        #43:#44        //  iterator:()Ljava/util/Iterator;
  #29 = Class              #38            //  java/util/Iterator
  #30 = NameAndType        #45:#46        //  hasNext:()Z
  #31 = NameAndType        #47:#48        //  next:()Ljava/lang/Object;
  #32 = Class              #49            //  java/lang/System
  #33 = NameAndType        #50:#51        //  out:Ljava/io/PrintStream;
  #34 = Class              #52            //  java/io/PrintStream
  #35 = NameAndType        #53:#54        //  println:(Ljava/lang/String;)V
  #36 = Utf8               test/lambda/LambdaCode
  #37 = Utf8               java/lang/Object
  #38 = Utf8               java/util/Iterator
  #39 = Utf8               java/util/Arrays
  #40 = Utf8               asList
  #41 = Utf8               ([Ljava/lang/Object;)Ljava/util/List;
  #42 = Utf8               java/util/List
  #43 = Utf8               iterator
  #44 = Utf8               ()Ljava/util/Iterator;
  #45 = Utf8               hasNext
  #46 = Utf8               ()Z
  #47 = Utf8               next
  #48 = Utf8               ()Ljava/lang/Object;
  #49 = Utf8               java/lang/System
  #50 = Utf8               out
  #51 = Utf8               Ljava/io/PrintStream;
  #52 = Utf8               java/io/PrintStream
  #53 = Utf8               println
  #54 = Utf8               (Ljava/lang/String;)V
{
  public test.lambda.LambdaCode();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0       
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return        
      LineNumberTable:
        line 15: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=3, args_size=1
         0: iconst_1      
         1: anewarray     #2                  // class java/lang/String
         4: dup           
         5: iconst_0      
         6: ldc           #3                  // String hello
         8: aastore       
         9: invokestatic  #4                  // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        12: invokeinterface #5,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
        17: astore_1      
        18: aload_1       
        19: invokeinterface #6,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
        24: ifeq          47
        27: aload_1       
        28: invokeinterface #7,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
        33: checkcast     #2                  // class java/lang/String
        36: astore_2      
        37: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        40: aload_2       
        41: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        44: goto          18
        47: return        
      LineNumberTable:
        line 35: 0
        line 36: 37
        line 37: 44
        line 38: 47
      StackMapTable: number_of_entries = 2
           frame_type = 252 /* append */
             offset_delta = 18
        locals = [ class java/util/Iterator ]
           frame_type = 250 /* chop */
          offset_delta = 28

}
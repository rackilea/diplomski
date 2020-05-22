Classfile LambdaCode.class
  Last modified 30.05.2013; size 1262 bytes
  MD5 checksum 4804e0a37b73141d5791cc39d51d649c
  Compiled from "LambdaCode.java"
public class test.lambda.LambdaCode
  SourceFile: "LambdaCode.java"
  InnerClasses:
       public static final #64= #63 of #70; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
  BootstrapMethods:
    0: #27 invokestatic java/lang/invoke/LambdaMetafactory.metaFactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
      Method arguments:
        #28 invokeinterface java/util/function/Consumer.accept:(Ljava/lang/Object;)V
        #29 invokestatic test/lambda/LambdaCode.lambda$0:(Ljava/lang/String;)V
        #30 (Ljava/lang/String;)V
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #10.#21        //  java/lang/Object."<init>":()V
   #2 = Class              #22            //  java/lang/String
   #3 = String             #23            //  hello
   #4 = Methodref          #24.#25        //  java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
   #5 = InvokeDynamic      #0:#31         //  #0:lambda$:()Ljava/util/function/Consumer;
   #6 = InterfaceMethodref #32.#33        //  java/util/List.forEach:(Ljava/util/function/Consumer;)V
   #7 = Fieldref           #34.#35        //  java/lang/System.out:Ljava/io/PrintStream;
   #8 = Methodref          #36.#37        //  java/io/PrintStream.println:(Ljava/lang/String;)V
   #9 = Class              #38            //  test/lambda/LambdaCode
  #10 = Class              #39            //  java/lang/Object
  #11 = Utf8               <init>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               main
  #16 = Utf8               ([Ljava/lang/String;)V
  #17 = Utf8               lambda$0
  #18 = Utf8               (Ljava/lang/String;)V
  #19 = Utf8               SourceFile
  #20 = Utf8               LambdaCode.java
  #21 = NameAndType        #11:#12        //  "<init>":()V
  #22 = Utf8               java/lang/String
  #23 = Utf8               hello
  #24 = Class              #40            //  java/util/Arrays
  #25 = NameAndType        #41:#42        //  asList:([Ljava/lang/Object;)Ljava/util/List;
  #26 = Utf8               BootstrapMethods
  #27 = MethodHandle       #6:#43         //  invokestatic java/lang/invoke/LambdaMetafactory.metaFactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #28 = MethodHandle       #9:#44         //  invokeinterface java/util/function/Consumer.accept:(Ljava/lang/Object;)V
  #29 = MethodHandle       #6:#45         //  invokestatic test/lambda/LambdaCode.lambda$0:(Ljava/lang/String;)V
  #30 = MethodType         #18            //  (Ljava/lang/String;)V
  #31 = NameAndType        #46:#47        //  lambda$:()Ljava/util/function/Consumer;
  #32 = Class              #48            //  java/util/List
  #33 = NameAndType        #49:#50        //  forEach:(Ljava/util/function/Consumer;)V
  #34 = Class              #51            //  java/lang/System
  #35 = NameAndType        #52:#53        //  out:Ljava/io/PrintStream;
  #36 = Class              #54            //  java/io/PrintStream
  #37 = NameAndType        #55:#18        //  println:(Ljava/lang/String;)V
  #38 = Utf8               test/lambda/LambdaCode
  #39 = Utf8               java/lang/Object
  #40 = Utf8               java/util/Arrays
  #41 = Utf8               asList
  #42 = Utf8               ([Ljava/lang/Object;)Ljava/util/List;
  #43 = Methodref          #56.#57        //  java/lang/invoke/LambdaMetafactory.metaFactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #44 = InterfaceMethodref #58.#59        //  java/util/function/Consumer.accept:(Ljava/lang/Object;)V
  #45 = Methodref          #9.#60         //  test/lambda/LambdaCode.lambda$0:(Ljava/lang/String;)V
  #46 = Utf8               lambda$
  #47 = Utf8               ()Ljava/util/function/Consumer;
  #48 = Utf8               java/util/List
  #49 = Utf8               forEach
  #50 = Utf8               (Ljava/util/function/Consumer;)V
  #51 = Utf8               java/lang/System
  #52 = Utf8               out
  #53 = Utf8               Ljava/io/PrintStream;
  #54 = Utf8               java/io/PrintStream
  #55 = Utf8               println
  #56 = Class              #61            //  java/lang/invoke/LambdaMetafactory
  #57 = NameAndType        #62:#66        //  metaFactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #58 = Class              #67            //  java/util/function/Consumer
  #59 = NameAndType        #68:#69        //  accept:(Ljava/lang/Object;)V
  #60 = NameAndType        #17:#18        //  lambda$0:(Ljava/lang/String;)V
  #61 = Utf8               java/lang/invoke/LambdaMetafactory
  #62 = Utf8               metaFactory
  #63 = Class              #71            //  java/lang/invoke/MethodHandles$Lookup
  #64 = Utf8               Lookup
  #65 = Utf8               InnerClasses
  #66 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #67 = Utf8               java/util/function/Consumer
  #68 = Utf8               accept
  #69 = Utf8               (Ljava/lang/Object;)V
  #70 = Class              #72            //  java/lang/invoke/MethodHandles
  #71 = Utf8               java/lang/invoke/MethodHandles$Lookup
  #72 = Utf8               java/lang/invoke/MethodHandles
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
      stack=4, locals=1, args_size=1
         0: iconst_1      
         1: anewarray     #2                  // class java/lang/String
         4: dup           
         5: iconst_0      
         6: ldc           #3                  // String hello
         8: aastore       
         9: invokestatic  #4                  // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        12: invokedynamic #5,  0              // InvokeDynamic #0:lambda$:()Ljava/util/function/Consumer;
        17: invokeinterface #6,  2            // InterfaceMethod java/util/List.forEach:(Ljava/util/function/Consumer;)V
        22: return        
      LineNumberTable:
        line 28: 0
        line 38: 22
}
public class ExampleClass
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #13.#36        // java/lang/Object."<init>":()V
   #2 = Class              #37            // ExampleClass
   #3 = Methodref          #2.#36         // ExampleClass."<init>":()V
   #4 = Methodref          #2.#38         // ExampleClass.exampleMethod:()V
   #5 = String             #39            // This is an example
   #6 = Class              #40            // java/lang/StringBuilder
   #7 = Methodref          #6.#36         // java/lang/StringBuilder."<init>":()V
   #8 = Methodref          #6.#41         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #9 = Methodref          #6.#42         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  #10 = Methodref          #6.#43         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #11 = Fieldref           #44.#45        // java/lang/System.out:Ljava/io/PrintStream;
  #12 = Methodref          #46.#47        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #13 = Class              #48            // java/lang/Object
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               LocalVariableTable
  #19 = Utf8               this
  #20 = Utf8               LExampleClass;
  #21 = Utf8               main
  #22 = Utf8               ([Ljava/lang/String;)V
  #23 = Utf8               args
  #24 = Utf8               [Ljava/lang/String;
  #25 = Utf8               exampleClass
  #26 = Utf8               exampleMethod
  #27 = Utf8               localResult
  #28 = Utf8               Ljava/lang/String;
  #29 = Utf8               counter
  #30 = Utf8               I
  #31 = Utf8               string
  #32 = Utf8               StackMapTable
  #33 = Class              #49            // java/lang/String
  #34 = Utf8               SourceFile
  #35 = Utf8               ExampleClass.java
  #36 = NameAndType        #14:#15        // "<init>":()V
  #37 = Utf8               ExampleClass
  #38 = NameAndType        #26:#15        // exampleMethod:()V
  #39 = Utf8               This is an example
  #40 = Utf8               java/lang/StringBuilder
  #41 = NameAndType        #50:#51        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #42 = NameAndType        #50:#52        // append:(I)Ljava/lang/StringBuilder;
  #43 = NameAndType        #53:#54        // toString:()Ljava/lang/String;
  #44 = Class              #55            // java/lang/System
  #45 = NameAndType        #56:#57        // out:Ljava/io/PrintStream;
  #46 = Class              #58            // java/io/PrintStream
  #47 = NameAndType        #59:#60        // println:(Ljava/lang/String;)V
  #48 = Utf8               java/lang/Object
  #49 = Utf8               java/lang/String
  #50 = Utf8               append
  #51 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #52 = Utf8               (I)Ljava/lang/StringBuilder;
  #53 = Utf8               toString
  #54 = Utf8               ()Ljava/lang/String;
  #55 = Utf8               java/lang/System
  #56 = Utf8               out
  #57 = Utf8               Ljava/io/PrintStream;
  #58 = Utf8               java/io/PrintStream
  #59 = Utf8               println
  #60 = Utf8               (Ljava/lang/String;)V
{
  public ExampleClass();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LExampleClass;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class ExampleClass
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: aload_1
         9: invokevirtual #4                  // Method exampleMethod:()V
        12: return
      LineNumberTable:
        line 4: 0
        line 5: 8
        line 6: 12
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      13     0  args   [Ljava/lang/String;
            8       5     1 exampleClass   LExampleClass;

  public void exampleMethod();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=4, args_size=1
         0: ldc           #5                  // String This is an example
         2: astore_1
         3: iconst_0
         4: istore_2
         5: iload_2
         6: bipush        10
         8: if_icmpge     43
        11: new           #6                  // class java/lang/StringBuilder
        14: dup
        15: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
        18: aload_1
        19: invokevirtual #8                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        22: iload_2
        23: invokevirtual #9                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        26: invokevirtual #10                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        29: astore_3
        30: getstatic     #11                 // Field java/lang/System.out:Ljava/io/PrintStream;
        33: aload_3
        34: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        37: iinc          2, 1
        40: goto          5
        43: return
      LineNumberTable:
        line 9: 0
        line 10: 3
        line 11: 11
        line 12: 30
        line 10: 37
        line 14: 43
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           30       7     3 localResult   Ljava/lang/String;
            5      38     2 counter   I
            0      44     0  this   LExampleClass;
            3      41     1 string   Ljava/lang/String;
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 5
          locals = [ class java/lang/String, int ]
        frame_type = 250 /* chop */
          offset_delta = 37
}
SourceFile: "ExampleClass.java"
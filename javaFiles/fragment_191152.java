public class ExampleClass
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #13.#22        // java/lang/Object."<init>":()V
   #2 = Class              #23            // ExampleClass
   #3 = Methodref          #2.#22         // ExampleClass."<init>":()V
   #4 = Methodref          #2.#24         // ExampleClass.exampleMethod:()V
   #5 = String             #25            // This is an example
   #6 = Class              #26            // java/lang/StringBuilder
   #7 = Methodref          #6.#22         // java/lang/StringBuilder."<init>":()V
   #8 = Methodref          #6.#27         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   #9 = Methodref          #6.#28         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  #10 = Methodref          #6.#29         // java/lang/StringBuilder.toString:()Ljava/lang/String;
  #11 = Fieldref           #30.#31        // java/lang/System.out:Ljava/io/PrintStream;
  #12 = Methodref          #32.#33        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #13 = Class              #34            // java/lang/Object
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               main
  #18 = Utf8               ([Ljava/lang/String;)V
  #19 = Utf8               exampleMethod
  #20 = Utf8               StackMapTable
  #21 = Class              #35            // java/lang/String
  #22 = NameAndType        #14:#15        // "<init>":()V
  #23 = Utf8               ExampleClass
  #24 = NameAndType        #19:#15        // exampleMethod:()V
  #25 = Utf8               This is an example
  #26 = Utf8               java/lang/StringBuilder
  #27 = NameAndType        #36:#37        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  #28 = NameAndType        #36:#38        // append:(I)Ljava/lang/StringBuilder;
  #29 = NameAndType        #39:#40        // toString:()Ljava/lang/String;
  #30 = Class              #41            // java/lang/System
  #31 = NameAndType        #42:#43        // out:Ljava/io/PrintStream;
  #32 = Class              #44            // java/io/PrintStream
  #33 = NameAndType        #45:#46        // println:(Ljava/lang/String;)V
  #34 = Utf8               java/lang/Object
  #35 = Utf8               java/lang/String
  #36 = Utf8               append
  #37 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
  #38 = Utf8               (I)Ljava/lang/StringBuilder;
  #39 = Utf8               toString
  #40 = Utf8               ()Ljava/lang/String;
  #41 = Utf8               java/lang/System
  #42 = Utf8               out
  #43 = Utf8               Ljava/io/PrintStream;
  #44 = Utf8               java/io/PrintStream
  #45 = Utf8               println
  #46 = Utf8               (Ljava/lang/String;)V
{
  public ExampleClass();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return

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
      StackMapTable: number_of_entries = 2
        frame_type = 253 /* append */
          offset_delta = 5
          locals = [ class java/lang/String, int ]
        frame_type = 250 /* chop */
          offset_delta = 37
}
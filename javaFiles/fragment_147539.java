#1 = Class              #2             // Sample
   #2 = Utf8               Sample
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
   #9 = NameAndType        #5:#6          // "<init>":()V
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               LSample;
  #14 = Utf8               main
  #15 = Utf8               ([Ljava/lang/String;)V
  #16 = Utf8               Exceptions
  #17 = Class              #18            // java/lang/Exception
  #18 = Utf8               java/lang/Exception
  #19 = String             #20            // ab
  #20 = Utf8               ab
  #21 = Class              #22            // java/lang/String
  #22 = Utf8               java/lang/String
  #23 = String             #24            // a
  #24 = Utf8               a
  #25 = Methodref          #21.#26        // java/lang/String."<init>":(Ljava/lang/String;)V
  #26 = NameAndType        #5:#27         // "<init>":(Ljava/lang/String;)V
  #27 = Utf8               (Ljava/lang/String;)V
  #28 = Utf8               args
  #29 = Utf8               [Ljava/lang/String;
  #30 = Utf8               s1
  #31 = Utf8               Ljava/lang/String;
  #32 = Utf8               s2
  #33 = Utf8               SourceFile
  #34 = Utf8               Sample.java
{
  Sample();
    descriptor: ()V
    flags:
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 5: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LSample;

  public static void main(java.lang.String...) throws java.lang.Exception;
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC, ACC_VARARGS
    Exceptions:
      throws java.lang.Exception
    Code:
      stack=3, locals=3, args_size=1
         0: ldc           #19                 // String ab
         2: astore_1
         3: new           #21                 // class java/lang/String
         6: dup
         7: ldc           #23                 // String a
         9: invokespecial #25                 // Method java/lang/String."<init>":(Ljava/lang/String;)V
        12: astore_2
        13: return
      LineNumberTable:
        line 8: 0
        line 9: 3
        line 10: 13
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      14     0  args   [Ljava/lang/String;
            3      11     1    s1   Ljava/lang/String;
           13       1     2    s2   Ljava/lang/String;
}
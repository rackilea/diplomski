$ cat Test.java 
public class Test {
  static String foo = "hello";
}


$ javap -p -c -s -v Test
Classfile /tmp/Test.class
  Last modified Feb 23, 2019; size 293 bytes
  MD5 checksum 724ea13308a150d0cc5730edcf4db616
  Compiled from "Test.java"
public class Test
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#15         // java/lang/Object."<init>":()V
   #2 = String             #16            // hello
   #3 = Fieldref           #4.#17         // Test.foo:Ljava/lang/String;
   #4 = Class              #18            // Test
   #5 = Class              #19            // java/lang/Object
   #6 = Utf8               foo
   #7 = Utf8               Ljava/lang/String;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               <clinit>
  #13 = Utf8               SourceFile
  #14 = Utf8               Test.java
  #15 = NameAndType        #8:#9          // "<init>":()V
  #16 = Utf8               hello
  #17 = NameAndType        #6:#7          // foo:Ljava/lang/String;
  #18 = Utf8               Test
  #19 = Utf8               java/lang/Object
{
  static java.lang.String foo;
    descriptor: Ljava/lang/String;
    flags: ACC_STATIC

  public Test();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: ldc           #2                  // String hello
         2: putstatic     #3                  // Field foo:Ljava/lang/String;
         5: return
      LineNumberTable:
        line 2: 0
}
SourceFile: "Test.java"
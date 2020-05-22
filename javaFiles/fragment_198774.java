[...]
public class SimpleProgram
  [...]
  this_class: #8                          // SimpleProgram
  super_class: #9                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #9.#23         // java/lang/Object."<init>":()V
   #2 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Class              #26            // java/lang/String
   #4 = String             #27            // a
   #5 = Methodref          #28.#29        // javafx/collections/FXCollections.observableArrayList:([Ljava/lang/Object;)Ljavafx/collections/ObservableList;
   #6 = InterfaceMethodref #30.#31        // javafx/collections/ObservableList.get:(I)Ljava/lang/Object;
   #7 = Methodref          #32.#33        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #8 = Class              #34            // SimpleProgram
   #9 = Class              #35            // java/lang/Object
  #10 = Utf8               <init>
  #11 = Utf8               ()V
  #12 = Utf8               Code
  #13 = Utf8               LineNumberTable
  #14 = Utf8               LocalVariableTable
  #15 = Utf8               this
  #16 = Utf8               LSimpleProgram;
  #17 = Utf8               main
  #18 = Utf8               ([Ljava/lang/String;)V
  #19 = Utf8               args
  #20 = Utf8               [Ljava/lang/String;
  #21 = Utf8               SourceFile
  #22 = Utf8               SimpleProgram.java
  #23 = NameAndType        #10:#11        // "<init>":()V
  #24 = Class              #36            // java/lang/System
  #25 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
  #26 = Utf8               java/lang/String
  #27 = Utf8               a
  #28 = Class              #39            // javafx/collections/FXCollections
  #29 = NameAndType        #40:#41        // observableArrayList:([Ljava/lang/Object;)Ljavafx/collections/ObservableList;
  #30 = Class              #42            // javafx/collections/ObservableList
  #31 = NameAndType        #43:#44        // get:(I)Ljava/lang/Object;
  #32 = Class              #45            // java/io/PrintStream
  #33 = NameAndType        #46:#47        // println:(Ljava/lang/String;)V
  #34 = Utf8               SimpleProgram
  #35 = Utf8               java/lang/Object
  #36 = Utf8               java/lang/System
  #37 = Utf8               out
  #38 = Utf8               Ljava/io/PrintStream;
  #39 = Utf8               javafx/collections/FXCollections
  #40 = Utf8               observableArrayList
  #41 = Utf8               ([Ljava/lang/Object;)Ljavafx/collections/ObservableList;
  #42 = Utf8               javafx/collections/ObservableList
  #43 = Utf8               get
  #44 = Utf8               (I)Ljava/lang/Object;
  #45 = Utf8               java/io/PrintStream
  #46 = Utf8               println
  #47 = Utf8               (Ljava/lang/String;)V
{
  public SimpleProgram();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      [...]
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LSimpleProgram;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=5, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: iconst_1
         4: anewarray     #3                  // class java/lang/String
         7: dup
         8: iconst_0
         9: ldc           #4                  // String a
        11: aastore
        12: invokestatic  #5                  // Method javafx/collections/FXCollections.observableArrayList:([Ljava/lang/Object;)Ljavafx/collections/ObservableList;
        15: iconst_0
        16: invokeinterface #6,  2            // InterfaceMethod javafx/collections/ObservableList.get:(I)Ljava/lang/Object;
        21: checkcast     #3                  // class java/lang/String
        24: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        27: return
      [...]
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      28     0  args   [Ljava/lang/String;
}
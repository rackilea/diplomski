public static void withoutCasts();
  Code:
   0:   iconst_2
   1:   istore_0
   2:   iload_0
   3:   istore_1
   4:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   7:   iload_1
   8:   invokevirtual   #3; //Method java/io/PrintStream.println:(I)V
   11:  return

public static void withCast();
  Code:
   0:   iconst_2
   1:   istore_0
   2:   iload_0
   3:   istore_1
   4:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   7:   iload_1
   8:   invokevirtual   #3; //Method java/io/PrintStream.println:(I)V
   11:  return
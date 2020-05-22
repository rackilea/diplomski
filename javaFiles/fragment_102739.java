public static void nestedIf(boolean, boolean);
  Code:
   0:   iload_0
   1:   ifeq    16
   4:   iload_1
   5:   ifeq    16
   8:   getstatic       #7; //Field java/lang/System.out:Ljava/io/PrintStream;
   11:  ldc     #8; //String a && b
   13:  invokevirtual   #9; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   16:  return

public static void logicalConditionIf(boolean, boolean);
  Code:
   0:   iload_0
   1:   ifeq    16
   4:   iload_1
   5:   ifeq    16
   8:   getstatic       #7; //Field java/lang/System.out:Ljava/io/PrintStream;
   11:  ldc     #8; //String a && b
   13:  invokevirtual   #9; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   16:  return
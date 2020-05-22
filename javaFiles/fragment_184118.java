public static void main(java.lang.String[]);
  Code:
   0:   ldc #2; //String abc
   2:   astore_1
   3:   aconst_null
   4:   astore_2
   5:   new #3; //class java/lang/StringBuilder
   8:   dup
   9:   invokespecial   #4; //Method java/lang/StringBuilder."<init>":()V
   12:  aload_1
   13:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   16:  aload_2
   17:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   20:  invokevirtual   #6; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   23:  astore_3
   24:  getstatic   #7; //Field java/lang/System.out:Ljava/io/PrintStream;
   27:  aload_3
   28:  invokevirtual   #8; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   31:  return
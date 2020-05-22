public static void main(java.lang.String[]);
  Code:
   0:   ldc             #2; //String a
   2:   astore_1
   3:   new             #3; //class java/lang/StringBuilder
   6:   dup
   7:   invokespecial   #4; //Method java/lang/StringBuilder."<init>":()V
   10:  aload_1
   11:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   14:  ldc             #6; //String b
   16:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   19:  invokevirtual   #7; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   22:  astore_1
   23:  new             #3; //class java/lang/StringBuilder
   26:  dup
   27:  invokespecial   #4; //Method java/lang/StringBuilder."<init>":()V
   30:  aload_1
   31:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   34:  ldc             #8; //String c
   36:  invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   39:  invokevirtual   #7; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   42:  astore_1
   43:  return   
}
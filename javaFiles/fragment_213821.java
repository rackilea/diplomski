public static void main(java.lang.String[]);
  Code:
   0:   new             #2; //class java/lang/StringBuilder
   3:   dup
   4:   ldc             #3; //String a
   6:   invokespecial   #4; //Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   9:   astore_1
   10:  aload_1
   11:  ldc             #5; //String b
   13:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   16:  pop
   17:  aload_1
   18:  ldc             #7; //String c
   20:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   23:  pop
   24:  return  
}
java.lang.String cat(java.lang.String, java.lang.String);
  Code:
   0:   new     #2; //class java/lang/StringBuilder
   3:   dup
   4:   invokespecial   #3; //Method java/lang/StringBuilder."<init>":()V
   7:   aload_1
   8:   invokevirtual   #4; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   11:  aload_2
   12:  invokevirtual   #4; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   15:  invokevirtual   #5; //Method java/lang/StringBuilder.toString:()Ljava/lang/    String;
   18:  astore_1
   19:  aload_1
   20:  areturn
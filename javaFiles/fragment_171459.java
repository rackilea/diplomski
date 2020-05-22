public void foo();
  Code:
   0:   iconst_5
   1:   istore_1
   2:   new     #2; //class java/lang/StringBuilder
   5:   dup
   6:   invokespecial   #3; //Method java/lang/StringBuilder."<init>":()V
   9:   iload_1
   10:  invokevirtual   #4; //Method java/lang/StringBuilder.append:(I)Ljava/lan
g/StringBuilder;
   13:  ldc     #5; //String
   15:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/
String;)Ljava/lang/StringBuilder;
   18:  invokevirtual   #7; //Method java/lang/StringBuilder.toString:()Ljava/la
ng/String;
   21:  astore_2
   22:  return
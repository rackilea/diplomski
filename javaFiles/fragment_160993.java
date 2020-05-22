10:  goto    36
   13:  new #24; //class java/lang/StringBuilder
   16:  dup
   17:  aload_1
   18:  invokestatic    #26; //Method java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
   21:  invokespecial   #32; //Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
   24:  ldc #35; //String k
   26:  invokevirtual   #37; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   29:  invokevirtual   #41; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   32:  astore_1
   33:  iinc    4, 1
   36:  iload   4
   38:  ldc #45; //int 100000
   40:  if_icmplt   13
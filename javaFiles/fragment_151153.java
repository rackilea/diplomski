static {};
  Code:
   0:   new #4; //class Name
   3:   dup
   4:   ldc #19; //String E1
   6:   iconst_0
   7:   ldc #20; //String hello
   9:   invokespecial   #21; //Method "<init>":(Ljava/lang/String;ILjava/lang/String;)V
   12:  putstatic   #22; //Field E1:LName;
   15:  new #4; //class Name
   18:  dup
   19:  ldc #23; //String E2
   21:  iconst_1
   22:  ldc #24; //String world
   24:  invokespecial   #21; //Method "<init>":(Ljava/lang/String;ILjava/lang/String;)V
   27:  putstatic   #25; //Field E2:LName;
   30:  iconst_2
   31:  anewarray   #4; //class Name
   34:  dup
   35:  iconst_0
   36:  getstatic   #22; //Field E1:LName;
   39:  aastore
   40:  dup
   41:  iconst_1
   42:  getstatic   #25; //Field E2:LName;
   45:  aastore
   46:  putstatic   #1; //Field $VALUES:[LName;
   49:  invokestatic    #26; //Method values:()[LName;
   52:  putstatic   #18; //Field values:[LName;
   55:  return

}
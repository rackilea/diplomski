public static void f2();
  Code:
   0:   lconst_0
   1:   lstore_0
   2:   invokestatic    #2; //Method java/lang/System.currentTimeMillis:()J
   5:   lstore_2
   6:   ldc2_w  #3; //long 2147483647l
   9:   lstore  4
   11:  lload   4
   13:  dup2
   14:  lconst_1
   15:  lsub
   16:  lstore  4
   18:  lconst_0
   19:  lcmp
   20:  ifle    31
   23:  lload_0
   24:  lload   4
   26:  ladd
   27:  lstore_0
   28:  goto    11
   31:  lload_0
   32:  ldc2_w  #3; //long 2147483647l
   35:  ladd
   36:  lstore_0
   37:  getstatic       #5; //Field java/lang/System.out:Ljava/io/PrintStream;
   40:  new     #6; //class java/lang/StringBuilder
   43:  dup
   44:  invokespecial   #7; //Method java/lang/StringBuilder."<init>":()V
   47:  ldc     #13; //String f2():
   49:  invokevirtual   #9; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   52:  invokestatic    #2; //Method java/lang/System.currentTimeMillis:()J
   55:  lload_2
   56:  lsub
   57:  invokevirtual   #10; //Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
   60:  invokevirtual   #11; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   63:  invokevirtual   #12; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   66:  return
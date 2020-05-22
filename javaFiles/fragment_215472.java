public void loop1();
  Code:
   0:   new #2; //class java/util/ArrayList
   3:   dup
   4:   invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   7:   astore_1
   8:   aload_1
   9:   invokevirtual   #4; //Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
   12:  astore_2
   13:  aload_2
   14:  invokeinterface #5,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   19:  ifeq    37
   22:  getstatic   #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   25:  aload_2
   26:  invokeinterface #7,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   31:  invokevirtual   #8; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   34:  goto    13
   37:  getstatic   #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   40:  ldc #9; //String Out
   42:  invokevirtual   #10; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   45:  return

public void loop2();
  Code:
   0:   new #2; //class java/util/ArrayList
   3:   dup
   4:   invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   7:   astore_1
   8:   aload_1
   9:   invokevirtual   #4; //Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
   12:  astore_2
   13:  aload_2
   14:  invokeinterface #5,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   19:  ifne    25
   22:  goto    40
   25:  getstatic   #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   28:  aload_2
   29:  invokeinterface #7,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   34:  invokevirtual   #8; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   37:  goto    13
   40:  getstatic   #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   43:  ldc #9; //String Out
   45:  invokevirtual   #10; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   48:  return
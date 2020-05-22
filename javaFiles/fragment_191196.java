public static void main(java.lang.String[]);
Code:
   Stack=3, Locals=2, Args_size=1
   0:   new #3; //class Test
   3:   dup
   4:   ldc #4; //String hello
   6:   invokespecial   #5; //Method "<init>":(Ljava/lang/Object;)V
   9:   astore_1
   10:  getstatic   #6; //Field java/lang/System.out:Ljava/io/PrintStream;
   13:  aload_1
   14:  getfield    #2; //Field contents:Ljava/lang/Object;
   17:  checkcast   #7; //class java/lang/String
   20:  invokevirtual   #8; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   23:  return
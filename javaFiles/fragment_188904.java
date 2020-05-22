public static void main(java.lang.String[]);
  Code:
   0:   iconst_0
   1:   istore_1
   2:   iload_1
   3:   aload_0
   4:   arraylength
   5:   if_icmpge   23
   8:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   11:  aload_0
   12:  iload_1
   13:  aaload
   14:  invokevirtual   #3; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   17:  iinc    1, 1
   20:  goto    2
   23:  return
public static void withoutCasts();
  Code:
   0:   new #6; //class SameTypeCastsDemo
   3:   dup
   4:   iconst_2
   5:   invokestatic    #7; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   8:   iconst_3
   9:   invokestatic    #7; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   12:  invokespecial   #8; //Method "<init>":(Ljava/lang/Integer;Ljava/lang/Integer;)V
   15:  astore_0
   16:  aload_0
   17:  astore_1
   18:  aload_1
   19:  invokevirtual   #9; //Method print:()V
   22:  return

public static void withCast();
  Code:
   0:   new #6; //class SameTypeCastsDemo
   3:   dup
   4:   iconst_2
   5:   invokestatic    #7; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   8:   iconst_3
   9:   invokestatic    #7; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   12:  invokespecial   #8; //Method "<init>":(Ljava/lang/Integer;Ljava/lang/Integer;)V
   15:  astore_0
   16:  aload_0
   17:  astore_1
   18:  aload_1
   19:  invokevirtual   #9; //Method print:()V
   22:  return
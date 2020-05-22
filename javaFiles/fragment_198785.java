private static void doSomethings(java.lang.Integer);
  Code:
   Stack=2, Locals=1, Args_size=1
   0:   aload_0
   1:   invokevirtual   #56; //Method java/lang/Integer.intValue:()I  --> get the int value of the Integer
   4:   iconst_1 --> constant value 1
   5:   iadd   --> add int value and 1
   6:   invokestatic    #16; //Method java/lang/Integer.valueOf:(I)Ljava/lang/In --> get another integer with value increased by 1
teger;
   9:   astore_0
   10:  return
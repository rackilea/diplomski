private boolean compare(java.lang.Object, int);
   Code:
      0: aload_1
      1: iload_2
      2: invokestatic  #2       // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      5: if_acmpne     12
      8: iconst_1
      9: goto          13
     12: iconst_0
     13: ireturn
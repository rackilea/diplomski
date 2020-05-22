public static void main(java.lang.String[]);
  Code:
   0:   iconst_0
   1:   istore_1
   2:   iload_1
   3:   iinc    1, 1
   6:   ldc #2; //int 2147483647
   8:   if_icmpge   14
   11:  goto    2
   14:  return

}
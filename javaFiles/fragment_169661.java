static void test(int);
  Code:
   0: iconst_0
   1: istore_1
   2: goto  12
   5: iload_0
   6: newarray long
   8: astore_2
   9: iinc  1, 1
   12:  iload_1
   13:  iconst_1
   14:  if_icmplt 5
   17:  iload_0
   18:  newarray long
   20:  astore_1
   21:  return
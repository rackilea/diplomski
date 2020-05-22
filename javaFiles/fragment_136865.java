public static boolean isPowerOfTwo(int);
  Code:
     0: iload_0
     1: ifle          14
//There's no 2 or 3 here...
     4: iload_0
     5: iload_0
     6: iconst_1
     7: isub
     8: iand
     9: ifne          14
//and no 10 or 11 here.
    12: iconst_1
    13: ireturn
    14: iconst_0
    15: ireturn
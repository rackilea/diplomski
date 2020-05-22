static void test1();               static void test2();
  Code:                              Code:
     0: iconst_0                        0: iconst_0
     1: istore_0                        1: istore_0
     2: goto          8                 2: goto          8
     5: iinc          0, 1              5: iinc          0, 1
     8: iload_0                         8: iload_0
     9: bipush        10                9: bipush        10
    11: if_icmplt     5                11: if_icmplt     5
    14: iconst_0                       14: iconst_0
    15: istore_0                       15: istore_0
    16: goto          22               16: goto          22
    19: iinc          0, 1             19: iinc          0, 1
    22: iload_0                        22: iload_0
    23: bipush        10               23: bipush        10
    25: if_icmplt     19               25: if_icmplt     19
    28: return                         28: return
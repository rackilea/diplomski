public int h1();
Code:
   0: aload_0
   1: getfield      #17                 // Field hash:I
   4: istore_1
   5: iload_1
   6: ifne          53
   9: aload_0
  10: getfield      #15                 // Field value:[C
  13: arraylength
  14: ifle          53
  17: aload_0
  18: getfield      #15                 // Field value:[C
  21: astore_2
  22: iconst_0
  23: istore_3
  24: goto          39
  27: bipush        31
  29: iload_1
  30: imul
  31: aload_2
  32: iload_3
  33: caload
  34: iadd
  35: istore_1
  36: iinc          3, 1
  39: iload_3
  40: aload_0
  41: getfield      #15                 // Field value:[C
  44: arraylength
  45: if_icmplt     27
  48: aload_0
  49: iload_1
  50: putfield      #17                 // Field hash:I
  53: iload_1
  54: ireturn

public int h2();
Code:
   0: aload_0
   1: getfield      #17                 // Field hash:I
   4: istore_1
   5: iload_1
   6: ifne          51
   9: aload_0
  10: getfield      #15                 // Field value:[C
  13: arraylength
  14: ifle          51
  17: iconst_0
  18: istore_2
  19: goto          37
  22: bipush        31
  24: iload_1
  25: imul
  26: aload_0
  27: getfield      #15                 // Field value:[C
  30: iload_2
  31: caload
  32: iadd
  33: istore_1
  34: iinc          2, 1
  37: iload_2
  38: aload_0
  39: getfield      #15                 // Field value:[C
  42: arraylength
  43: if_icmplt     22
  46: aload_0
  47: iload_1
  48: putfield      #17                 // Field hash:I
  51: iload_1
  52: ireturn
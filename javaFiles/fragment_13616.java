public static int tintABGRPixel(int, Color);
    Code:
       0: iload_0
       1: bipush        16
       3: ishr
       4: sipush        255
       7: iand
       8: i2d
       9: ldc2_w        #2                  // double 0.2126d
      12: dmul
      13: iload_0
      ...
      37: dadd
      38: ldc2_w        #8                  // double 255.0d
      41: ddiv
      42: dstore_2
      43: iload_0
      44: bipush        24
      46: ishr
      47: sipush        255
      50: iand
      51: bipush        24
      53: ishl
      54: aload_1
      55: pop
      56: invokestatic  #10                 // Method Color.getBlue:()I
      59: i2d
      60: dload_2
      61: dmul
      62: d2i
      63: sipush        255
      66: iand
      67: ior
      68: aload_1
      69: pop
      ...
      102: ireturn
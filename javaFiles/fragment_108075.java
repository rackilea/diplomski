int testSeparate(int);
    Code:
       0: aload_0
       1: getfield      #15                 // Field table:[Lstackoverflow/Node;
       4: astore_2
       5: aload_2
       6: ifnull        40
       9: aload_2
      10: arraylength
      11: istore_3
      12: iload_3
      13: ifle          40
      16: aload_2
      17: iload_3
      18: iconst_1
      19: isub
      20: aaload
      21: astore        4
      23: aload         4
      25: ifnull        40
      28: aload         4
      30: getfield      #37                 // Field stackoverflow/Node.k:I
      33: aload         4
      35: getfield      #41                 // Field stackoverflow/Node.j:I
      38: iadd
      39: ireturn
      40: iconst_0
      41: ireturn
int testInlined(int);
    Code:
       0: aload_0
       1: getfield      #15                 // Field table:[Lstackoverflow/Node;
       4: dup
       5: astore_2
       6: ifnull        38
       9: aload_2
      10: arraylength
      11: dup
      12: istore        5
      14: ifle          38
      17: aload_2
      18: iload         5
      20: iconst_1
      21: isub
      22: aaload
      23: dup
      24: astore_3
      25: ifnull        38
      28: aload_3
      29: getfield      #37                 // Field stackoverflow/Node.k:I
      32: aload_3
      33: getfield      #41                 // Field stackoverflow/Node.j:I
      36: iadd
      37: ireturn
      38: iconst_0
      39: ireturn
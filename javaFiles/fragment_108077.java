int testRepeated(int);
    Code:
       0: aload_0
       1: getfield      #15                 // Field table:[Lstackoverflow/Node;
       4: ifnull        62
       7: aload_0
       8: getfield      #15                 // Field table:[Lstackoverflow/Node;
      11: arraylength
      12: ifle          62
      15: aload_0
      16: getfield      #15                 // Field table:[Lstackoverflow/Node;
      19: aload_0
      20: getfield      #15                 // Field table:[Lstackoverflow/Node;
      23: arraylength
      24: iconst_1
      25: isub
      26: aaload
      27: ifnull        62
      30: aload_0
      31: getfield      #15                 // Field table:[Lstackoverflow/Node;
      34: aload_0
      35: getfield      #15                 // Field table:[Lstackoverflow/Node;
      38: arraylength
      39: iconst_1
      40: isub
      41: aaload
      42: getfield      #37                 // Field stackoverflow/Node.k:I
      45: aload_0
      46: getfield      #15                 // Field table:[Lstackoverflow/Node;
      49: aload_0
      50: getfield      #15                 // Field table:[Lstackoverflow/Node;
      53: arraylength
      54: iconst_1
      55: isub
      56: aaload
      57: getfield      #41                 // Field stackoverflow/Node.j:I
      60: iadd
      61: ireturn
      62: iconst_0
      63: ireturn
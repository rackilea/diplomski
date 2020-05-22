static {};
    Code:
       0: new           #1                  // class playground/Color
       3: dup           
       4: ldc           #14                 // String RED
       6: iconst_0      
       7: invokespecial #15                 // Method "<init>":(Ljava/lang/String;I)V
      10: putstatic     #19                 // Field RED:Lplayground/Color;
      13: new           #1                  // class playground/Color
      16: dup           
      17: ldc           #21                 // String GREEN
      19: iconst_1      
      20: invokespecial #15                 // Method "<init>":(Ljava/lang/String;I)V
      23: putstatic     #22                 // Field GREEN:Lplayground/Color;
      26: new           #1                  // class playground/Color
      29: dup           
      30: ldc           #24                 // String BLUE
      32: iconst_2      
      33: invokespecial #15                 // Method "<init>":(Ljava/lang/String;I)V
      36: putstatic     #25                 // Field BLUE:Lplayground/Color;
      39: iconst_3      
      40: anewarray     #1                  // class playground/Color
      43: dup           
      44: iconst_0      
      45: getstatic     #19                 // Field RED:Lplayground/Color;
      48: aastore       
      49: dup           
      50: iconst_1      
      51: getstatic     #22                 // Field GREEN:Lplayground/Color;
      54: aastore       
      55: dup           
      56: iconst_2      
      57: getstatic     #25                 // Field BLUE:Lplayground/Color;
      60: aastore       
      61: putstatic     #27                 // Field ENUM$VALUES:[Lplayground/Color;
      64: return
public static void main(java.lang.String[]);
    Code:
    // FOR listOne
       0: new           #2                  // class java/util/ArrayList
       3: dup           
       4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       7: astore_1      
       8: aload_1       
       9: iconst_1      
      10: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      13: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
      18: pop           
      19: aload_1       
      20: iconst_0      
      21: invokeinterface #6,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      26: checkcast     #7                  // class java/lang/Integer
      29: invokevirtual #8                  // Method java/lang/Integer.intValue:()I
      32: istore_2      
   // FOR listTwo
      33: new           #2                  // class java/util/ArrayList
      36: dup           
      37: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
      40: astore_3      
      41: aload_3       
      42: iconst_1      
      43: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
      46: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
      51: pop           
      52: aload_3       
      53: iconst_0      
      54: invokeinterface #6,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
      59: checkcast     #7                  // class java/lang/Integer
      62: invokevirtual #8                  // Method java/lang/Integer.intValue:()I
      65: istore        4
      67: return        
}
7: astore_3
   8: iinc          1, 1
  11: iload_1
  12: iload_2
  13: if_icmpge     49
  16: aload_3
  17: checkcast     #3                  // class java/lang/Comparable
  20: aload_0
  21: iload_1
  22: invokeinterface #2,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
  27: invokeinterface #4,  2            // InterfaceMethod java/lang/Comparable.compareTo:(Ljava/lang/Object;)I
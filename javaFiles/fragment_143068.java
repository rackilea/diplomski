77: invokeinterface #10,  1           // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
  82: astore        6
  84: aload         6
  86: invokeinterface #11,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
  91: ifeq          109
  94: aload         6
  96: invokeinterface #12,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
 101: checkcast     #13                 // class java/lang/Integer
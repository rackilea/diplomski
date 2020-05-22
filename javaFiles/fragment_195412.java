24: invokeinterface #33,  1           // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
  29: astore_3      
  30: goto          50
  33: aload_3       
  34: invokeinterface #39,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
  39: checkcast     #19                 // class java/lang/String
  42: astore_2      
  43: getstatic     #45                 // Field java/lang/System.out:Ljava/io/PrintStream;
  46: aload_2       
  47: invokevirtual #51                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
  50: aload_3       
  51: invokeinterface #57,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
  56: ifne          33
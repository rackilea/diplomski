0: new           #2                  // class java/util/ArrayList
   3: dup
   4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
   7: astore_1
   8: aload_1
   9: astore_2
  10: aload_2
  11: ldc           #4                  // String test
  13: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
  18: pop
  19: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
  22: aload_1
  23: iconst_0
  24: invokeinterface #7,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
  29: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
  32: return
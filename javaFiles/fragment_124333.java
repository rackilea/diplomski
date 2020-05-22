public static void doThingsWithList();
  Code:
     0: new           #11                 // class java/util/ArrayList
     3: dup
     4: invokespecial #12                 // Method java/util/ArrayList."<init>":()V
     7: astore_0
     8: aload_0
     9: ldc           #13                 // String
    11: invokevirtual #14                 // Method java/util/ArrayList.add:(Ljava/lang/Object;)Z
    14: pop
    15: aload_0
    16: iconst_0
    17: invokevirtual #15                 // Method java/util/ArrayList.get:(I)Ljava/lang/Object;
    20: checkcast     #16                 // class java/lang/String
    23: astore_1
    24: aload_1
    25: invokestatic  #17                 // Method print:(Ljava/lang/Object;)V
    28: return
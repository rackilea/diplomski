private static <T extends java/lang/Object> void test();
Code:
   0: new           #3                  // class quicktest/DispatchTest
   3: dup
   4: invokespecial #4                  // Method "<init>":()V
   7: astore_0
   8: new           #5                  // class java/util/HashMap
  11: dup
  12: invokespecial #6                  // Method java/util/HashMap."<init>":()V
  15: astore_1
  16: aload_0
  17: iconst_1
  18: anewarray     #7                  // class java/lang/Object
  21: dup
  22: iconst_0
  23: aload_1
  24: aastore
  25: invokevirtual #8                  // Method bar:([Ljava/lang/Object;)V

  28: return
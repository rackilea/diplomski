static {};
    flags: ACC_STATIC
    Code:
      stack=5, locals=0, args_size=0
         0: new           #4                  // class Foo
         3: dup
         4: ldc           #7                  // String CONSTANT
         6: iconst_0
         7: iconst_1
         8: invokespecial #8                  // Method "<init>":(Ljava/lang/String;II)V
        11: putstatic     #9                  // Field CONSTANT:LFoo;
        14: iconst_1
        15: anewarray     #4                  // class Foo
        18: dup
        19: iconst_0
        20: getstatic     #9                  // Field CONSTANT:LFoo;
        23: aastore
        24: putstatic     #1                  // Field $VALUES:[LFoo;
        27: return
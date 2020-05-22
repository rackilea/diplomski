private static java.lang.String lambda$bar$1(java.lang.String);
    descriptor: (Ljava/lang/String;)Ljava/lang/String;
    flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
    Code:
      stack=3, locals=1, args_size=1
         0: aload_0
         1: ldc           #8                  // String a
         3: ldc           #9                  // String *
         5: invokevirtual #10                 // Method java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
         8: areturn
      LineNumberTable:
        line 18: 0

  private static java.lang.String lambda$foo$0(java.lang.String);
    descriptor: (Ljava/lang/String;)Ljava/lang/String;
    flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
    Code:
      stack=3, locals=2, args_size=1
         0: aload_0
         1: ldc           #8                  // String a
         3: ldc           #9                  // String *
         5: invokevirtual #10                 // Method java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
         8: astore_1
         9: aload_1
        10: areturn
      LineNumberTable:
        line 11: 0
        line 12: 9
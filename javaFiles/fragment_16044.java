static java.lang.Class class$(java.lang.String);
  Code:
     0: aload_0
     1: invokestatic  #1                  // Method java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
     4: areturn
     5: astore_1
     6: new           #3                  // class java/lang/NoClassDefFoundError
     9: dup
    10: invokespecial #4                  // Method java/lang/NoClassDefFoundError."<init>":()V
    13: aload_1
    14: invokevirtual #5                  // Method java/lang/NoClassDefFoundError.initCause:(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    17: athrow
  Exception table:
     from    to  target type
         0     4     5   Class java/lang/ClassNotFoundException
public static java.lang.Class<?> viaGetClass();
    Code:
       0: iconst_0
       1: anewarray     #1                  // class java/lang/String
       4: invokevirtual #2                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
       7: areturn

public static java.lang.Class<?> viaClassLiteral();
    Code:
       0: ldc           #3                  // class "[Ljava/lang/String;"
       2: areturn
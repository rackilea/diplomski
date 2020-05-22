public static void main(java.lang.String...);
    flags: ACC_PUBLIC, ACC_STATIC, ACC_VARARGS
    Code:
      stack=5, locals=3, args_size=1
         0: ldc2_w        #16                 // double 9.0d
         3: dstore_1
         4: getstatic     #18                 // Field java/lang/System.out:Ljav
a/io/PrintStream;
         7: new           #24                 // class java/lang/StringBuilder
        10: dup
        11: dload_1
        12: invokestatic  #26                 // Method java/lang/String.valueOf
:(D)Ljava/lang/String;
        15: invokespecial #32                 // Method java/lang/StringBuilder.
"<init>":(Ljava/lang/String;)V
        18: ldc           #35                 // String hi
        20: invokevirtual #37                 // Method java/lang/StringBuilder.
append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        23: invokevirtual #41                 // Method java/lang/StringBuilder.
toString:()Ljava/lang/String;
        26: invokevirtual #45                 // Method java/io/PrintStream.prin
tln:(Ljava/lang/String;)V
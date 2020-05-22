$ javap -v Main.class

  public static void main(java.lang.String[]) throws java.lang.Exception;
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=3, args_size=1
         0: dconst_1
         1: ldc2_w        #2                  // double -50.0d
         4: invokestatic  #4                  // Method java/lang/Math.exp:(D)D
         7: dsub
         8: dstore_1
         9: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
        12: dload_1
        13: invokevirtual #6                  // Method java/io/PrintStream.println:(D)V
        16: return
}
SourceFile: "Main.java"
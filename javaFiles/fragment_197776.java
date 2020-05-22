public static void main(java.lang.String[]);
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class java/lang/StringBuilder
         3: dup           
         4: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
         7: iconst_1      
         8: invokestatic  #4                  // Method java/lang/Integer.toString:(I)Ljava/lang/String;
        11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        14: iconst_1      
        15: invokestatic  #4                  // Method java/lang/Integer.toString:(I)Ljava/lang/String;
        18: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        21: iconst_1      
        22: invokestatic  #4                  // Method java/lang/Integer.toString:(I)Ljava/lang/String;
        25: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        28: invokevirtual #6                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        31: astore_1      
        32: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
        35: aload_1       
        36: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        39: return
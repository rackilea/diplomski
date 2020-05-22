public static void main(java.lang.String[]);
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: iconst_1      
         1: istore_1      
         2: new           #2                  // class java/lang/StringBuilder
         5: dup           
         6: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
         9: iload_1       
        10: invokevirtual #4                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        13: ldc           #5                  // String 
        15: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        18: iload_1       
        19: invokevirtual #4                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        22: ldc           #5                  // String 
        24: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        27: iload_1       
        28: invokevirtual #4                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        31: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        34: astore_2      
        35: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        38: aload_2       
        39: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        42: return
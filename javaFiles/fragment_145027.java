Code:
   0: iconst_1      
   1: istore_1      
   2: getstatic     #59                 // Field java/lang/System.out:Ljava/io/PrintStream;
   5: new           #166                // class java/lang/StringBuilder
   8: dup           
   9: ldc           #168                // String the value of bool is : 
  11: invokespecial #170                // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
  14: iload_1       
  15: invokevirtual #172                // Method java/lang/StringBuilder.append:(Z)Ljava/lang/StringBuilder;
  18: invokevirtual #176                // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
  21: invokevirtual #69                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
  24: return
protected void protectedMethod();
    Code:
       0: getstatic     #44             // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #47             // String protected
       5: invokevirtual #46             // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return        

  public void publicMethod();
    Code:
       0: getstatic     #44             // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #48             // String public
       5: invokevirtual #46             // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return        

  void method();
    Code:
       0: getstatic     #44             // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #49             // String method
       5: invokevirtual #46             // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
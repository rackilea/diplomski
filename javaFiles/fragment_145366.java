void foo();
    flags: 
    Code:
        stack=2, locals=1, args_size=1
            0: aload_0       
            1: invokespecial #2        // Method Super.foo:()V
            4: getstatic     #3        // Field java/lang/System.out:Ljava/io/PrintStream;
            7: ldc           #4        // String Sub
            9: invokevirtual #5        // Method java/io/PrintStream.println:(Ljava/lang/String;)V
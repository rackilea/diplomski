// The following statement causes the compiler to generate
        // the error "local variables referenced from a lambda expression
        // must be final or effectively final" in statement A:
        //
        // x = 99;

        Block<Integer> myBlock = (y) -> 
        {
            System.out.println("x = " + x); // Statement A
            System.out.println("y = " + y);
            System.out.println("this.x = " + this.x);
            System.out.println("LambdaScopeTest.this.x = " +
                LambdaScopeTest.this.x);
        };
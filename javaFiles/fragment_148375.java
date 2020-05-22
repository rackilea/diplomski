HelloWorld spanishGreeting = new HelloWorld() {

        String name = "mundo"; //Statement2

        double aValue = 0.0;

        String s = "Hi"; //instance variable initializers are allowed

       // assignment statement
        aValue = 8933.234; // not allowed

        // increment statement
        aValue++; // not allowed

        // method invocation statement
        System.out.println("Hello World!"); // not allowed

        // object creation statement
        Bicycle myBike = new Bicycle(); //instance variable initializers are allowed

        public void greet() {
            greetSomeone("mundo");
        }
        public void greetSomeone(String someone) {
            name = someone;
            System.out.println("Hola, " + name);
        }
    };
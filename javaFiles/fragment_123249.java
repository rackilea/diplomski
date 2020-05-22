Sayable sayable = new Sayable() {

    @Override
    void say() {
        // Grab the body of the method referenced by the method reference,
        // which is the following:
        System.out.println("Hello, this is static method.");
    }
}
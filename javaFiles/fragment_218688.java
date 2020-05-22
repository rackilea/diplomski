final class HelloWorld {

    private HelloWorld() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
    }

    public static void main(String[] args) {
        System.out.println("Hola Mundo!");
    }
}
BEFORE:
class Test {

    private static final String CONST = "This is a constant";

    public static void main(String[] args) {
        System.out.println("Hello: " + CONST);
    }
}

AFTER:
class Test {

    private static final String CONST = "";

    public static void main(String[] args) {
        System.out.println("" + CONST);
    }
}
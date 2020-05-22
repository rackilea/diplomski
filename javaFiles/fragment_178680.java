public static void one() throws Exception {
    try {
        System.out.println("One");
        throw new Exception();
    } catch (Exception e) {
        System.out.println("Catch one");
        if (2 != 3) throw new Exception(); // "if" silences compiler's check
    } finally {
        System.out.println("Finally one");
    }
}
public static void two() throws Exception {
    try {
        System.out.println("Two");
        throw new Exception();
    } catch (Exception e) {
        System.out.println("Catch two");
        if (2 != 3) throw new Exception(); // "if" silences compiler's check
    }
    System.out.println("After two");
}
public static void error() throws Exception {
    try {
        System.out.println("Try");
        throw new Error();
    } catch (Exception e) {
        System.out.println("Catch");
        throw new Exception();
    } finally {
        System.out.println("Finally");
    }
}
class Exception {
    public static void main(String args[]) {

        int x = 10;
        int y = 0;

        int result;

        try {
            result = x / y;
        } catch (ArithmeticException e) {
            System.out.println("Throwing the exception");
            throw new ArithmeticException();
        } catch (java.lang.Exception ae) {
            System.out.println("Caught the rethrown exception");
        }
    }
}
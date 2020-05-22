public class Main {
    public static void main(String[] args) {
        try {
            int a=2/0;
        } catch (ArithmeticException e) {
            ExceptionPrinter.printException(e, Main.class, "main", "Input file not found");
        } catch (NullPointerException e) {
            ExceptionPrinter.printException(e, Main.class, "main", "Exception occurred during parsing");
        }
    }

}
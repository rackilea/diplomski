public class HelloWorld {

    private static int a = 1;
    private static int b = 1;
    public static void main(String[] args) {
        if (isCorrect(a, b)) {
            debug.setText("YES!");
        }
        if (!isCorrect(a, b)) {
            debug.setText("NO!");
        }
    }

    public static boolean isCorrect(int a, int b) {
        boolean ok = false;

        if (a == b) {
            ok = true;
        }
        return ok;
    }
}
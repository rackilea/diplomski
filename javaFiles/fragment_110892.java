public class Main {

    private static Scanner in = new Scanner(System.in);

    private static SetnGet sng = new SetnGet();

    public static void main(String[] args) {
        int selectedKey = possibleKey();
        sng.accessibleKey(selectedKey);
        int level = possibleLevel();
    }

    public static int possibleKey() {
        // your initial implementation of the method
    }

    public static int possibleLevel() {
        // your initial implementation of the method, but
        // without the "SetnGet sng = new SetnGet();" line
    }
}
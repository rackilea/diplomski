public class Main {

    static {
        System.loadLibrary("mynative");
    }

    private static native String[][] getStringArrays();

    public static void main(String[] args) {
        for (String[]  array : getStringArrays())
            for (String s : array)
                System.out.println(s);
    }
}
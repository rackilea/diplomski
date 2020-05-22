$ cat test.txt
private int x = "3";
private static x = "3";
private final static String x = "3";
private static final String x = "3";
private static String x = "3";
public static void main(String args[]) {
        blah;
}

$ grep "[^(final)] static [^(final)][^(\})]*$" test.txt
private static x = "3";
private static String x = "3";
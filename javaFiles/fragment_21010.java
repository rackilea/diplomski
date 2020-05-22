private static Map<Integer, String> spaces = new HashMap<>();

public static String spaces(int n) {
    String s = spaces.get(n);
    if (s == null) {
        spaces.put(n, s = makeFilledString(n, ' '));
    }
    return s;
}
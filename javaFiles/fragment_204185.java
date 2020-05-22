public static void main(String[] args) {
    String s = "ROHIT";
    int size = s.length() * 2;
    int max = s.length();
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            int level = Math.min(normalize(i, max), normalize(j, max));
            System.out.print(s.charAt(level));
        }
        System.out.println("");
    }
}

private static int normalize(int i, int max) {
    return (i >= max) ? 2 * max - i - 1: i;
}
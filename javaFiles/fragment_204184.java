public static void main(String[] args) {
    String s = "ROHIT";
    int size = s.length() * 2;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if ((j > i && size - j > i) || (size - j > size - i && j >= size - i)) {
                print(s, i);
            } else {
                print(s, j);
            }
        }
        System.out.println("");
    }
}

private static void print(String s, int i) {
    if (i < s.length()) {
        System.out.print(s.charAt(i));
    } else {
        System.out.print(s.charAt(s.length() - i % s.length() - 1));
    }
}
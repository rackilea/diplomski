public static void main(String[] args) {
    String a = "hi", b = "hey", c = "hello";
    int max = Math.max(a.length(), Math.max(b.length(), c.length()));
    for (int i = 0; i < max; i++) {
        Character x = i >= a.length() ? null : a.charAt(i), 
                y = i >= b.length() ? null : b.charAt(i),
                z = i >= c.length() ? null : c.charAt(i);
        printChar(x, y, z);
    }
}

public static void printChar(Character a, Character b, Character c) {
    if (a != null) {
        System.out.printf("A char val : %c ", a);
    }
    if (b != null) {
        System.out.printf("B char val : %c ", b);
    }
    if (c != null) {
        System.out.printf("C char val : %c", c);
    }
    System.out.println();
}
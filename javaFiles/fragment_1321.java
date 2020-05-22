public static void main(String[] args) {
    printRhombusText("yolobird");
}

public static void printRhombusText(String s) {
    // top part
    for (int i = 1; i <= s.length(); ++i) {
        System.out.println(s.substring(0, i));
    }
    // bottom part
    for (int i = 1; i <= s.length(); ++i) {
        // print out the space
        for (int y = i; y > 0; --y) {
            System.out.print(" ");
        }
        System.out.println(s.substring(i));
    }
}
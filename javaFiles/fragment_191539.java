private static void addNumToChar(int a, char c0) {
    char c = 'a';
    if(Character.isUpperCase(c0)) {
        c = 'A';
    }
    while (a < 0) a += 26;
    char c1 = (char) (c + (c0 - c + a) % 26);
    System.out.println(c1);
}
public static void main(String[] args) {
    char character = 'A';
    String characterCode;
    for (int foreground = 30; foreground < 38; foreground++) {
        for (int background = 40; background < 48; background++) {
            characterCode = "\033[" + foreground + ";" + background + ";1m";
            System.out.print(characterCode + character);
        }
        System.out.println();
    }

}
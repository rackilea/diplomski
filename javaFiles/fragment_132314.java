class a {
    public static void changeLetter(Character ch) {
        ch = 'D';
    }

    public static void main(String[] args) throws Exception {
        Character d = 'a';
        changeLetter(d);
        System.out.println(d);
    }
}
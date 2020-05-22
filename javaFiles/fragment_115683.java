public static void main(String[] args) {
    String s = "s[film] fever(normal) curse;";
    String[] spart = s.split("[,/?:;\\[\\]\"{}()\\-_+*=|<>!`~@#$%^&\\s]+");
    for (String string : spart) {
        System.out.println("'"+string+"'");
    }
}
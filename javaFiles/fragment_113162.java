public static void main(String[] args) {
    String str = "TW12EF";

    int insertPos = str.length() - 4;
    if (insertPos >= 0) {
        char ch = str.charAt(insertPos);
        if (!Character.isWhitespace(ch)) {
            str = new StringBuilder(str).insert(insertPos + 1, ' ').toString();
        }
    }

    System.out.println(str);
}
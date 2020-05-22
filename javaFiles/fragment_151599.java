public static String beginWithB(String wordlist) {
    StringBuilder sb = new StringBuilder();
    String myStr = wordlist;
    for (String b : myStr.split(" ")) {
        if (b.startsWith("b") || b.startsWith("B")) {
            sb.append(b + " ");
        }
    }
    return sb.toString();
}
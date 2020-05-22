public static String moveAllXsRight(char a, String b) {
    StringBuilder sb = new StringBuilder(b);

    for(int i = 0; i < sb.length() - 1; i++) {
        if(sb.charAt(i) == a) {
            // swapping with the right character
            sb.setCharAt(i, sb.charAt(i + 1));
            sb.setCharAt(i + 1, a);
            // skipping next index (because we already know it contains `a`)
            i = i + 1;
        }
    }

    return sb.toString();
}
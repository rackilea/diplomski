public static String digestToReadableString(byte[] digest){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digest.length; i++) {
        String s = Integer.toHexString(digest[i]);
        while (s.length() < 2) {
            s = "0" + s;
        }
        s = s.substring(s.length() - 2); // we need the last 2 chars
        sb.append(s);
    }
    return sb.toString();
}
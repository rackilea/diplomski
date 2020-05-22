private static String addSpacesEvery5(String s) {
    StringBuilder out = new StringBuilder();
    for (int i = 0 ; i < s.length() ; i++) {
        if (i % 5 == 0 && i != 0) {
            out.append(" ");
        }
        out.append(s.charAt(i));
    }
    return out.toString();
}
private static String addSpacesEvery5(String s) {
    String out = "";
    for (int i = 0 ; i < s.length() ; i++) {
        if (i % 5 == 0 && i != 0) {
            out += " "; // this will run once every five iterations, except the first one
        }
        out += s.charAt(i);
    }
    return out;
}
private static String encrypt(String s) {
    StringBuilder builder = new StringBuilder();
    s.chars().forEach(x -> {
        char c = (char)x;
        if (c == 'v' || c == 'V') {
            builder.append("ag',r");
        } else if (c == 'm' || c == 'M') {
            builder.append("ssad");
        } else if (c == 'g' || c == 'G') {
            builder.append("jeb..w");
        } else if (c == 'b' || c == 'B') {
            builder.append("dug>?/");
        } else {
            builder.append(c);
        }
    });
    return builder.toString();
}
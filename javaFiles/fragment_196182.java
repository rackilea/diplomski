static String join(Object... words) {
    StringBuilder sb = new StringBuilder();

    if (words.length > 0) {
        sb.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            sb.append(", ").append(words[i].toString());
        }
    }

    return sb.toString();
}
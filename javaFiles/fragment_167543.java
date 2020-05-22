public static String concat(String[] array) {
    StringBuilder builder = new StringBuilder();
    for(String s : array)
        builder.append(s);
    return builder.toString();
}
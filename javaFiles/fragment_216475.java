public static String swap(String org, String swapA, String swapB) {
    String swapAEscaped = swapA.replaceAll("([\\[\\]\\\\+*?(){}^$])", "\\\\$1");
    StringBuilder builder = new StringBuilder(org.length());

    String[] split = org.split(swapAEscaped);

    for (int i = 0; i < split.length; i++) {
        builder.append(split[i].replace(swapB, swapA));
        if (i != (split.length - 1)) {
            builder.append(swapB);
        }
    }

    return builder.toString();

}
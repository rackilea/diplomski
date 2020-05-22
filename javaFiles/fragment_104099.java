public static String swapCase(String s) {
    String swapped = "";
    for (int i = 0; i < s.length(); i++) {

        if (Character.isLowerCase(s.charAt(i))) {
            swapped += String.valueOf(Character.toUpperCase(s.charAt(i)));
        } else if (Character.isUpperCase(s.charAt(i))) {
            swapped += String.valueOf(Character.toLowerCase(s.charAt(i)));
        }

    }

    return swapped;
}
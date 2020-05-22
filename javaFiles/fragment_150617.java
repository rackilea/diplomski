public static String method(boolean value) {
    String someString;

    if (value) {
        StringBuilder sb = new StringBuilder();
        sb.append("one");
        sb.append(value);
        someString = sb.toString();
    } else {
        StringBuilder sb = new StringBuilder();
        sb.append("two");
        sb.append(value);
        someString = sb.toString();
    }
    return someString;
}
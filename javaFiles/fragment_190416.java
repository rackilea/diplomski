private static String multiply(String str, int times) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < times; i++) {
        sb.append(str).append(".");
    }
    return sb.toString();
}
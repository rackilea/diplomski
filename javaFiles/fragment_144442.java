public static String binaryCode(int n) {
    StringBuilder sb = new StringBuilder();
    for(int i = n; i > 0; i /= 2) {
        sb.append(i%2);
    }
    return sb.toString();
}
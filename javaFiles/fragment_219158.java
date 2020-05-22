static int generateFirstPal(int x) {
    String y = String.valueOf(x);
    String firstPart = y.substring(0, y.length() / 2);
    return Integer.parseInt(firstPart);
}

static int generateSecondPal(int x) {
    String y = String.valueOf(x);
    String secondPart = y.substring(y.length() / 2);
    return Integer.parseInt(secondPart);
}
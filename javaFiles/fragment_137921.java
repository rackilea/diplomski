public static void main(String[] args) throws Exception {
    System.out.println(toHex(0, 5));
    System.out.println(toHex(1, 5));
    System.out.println(toHex(10, 5));
    System.out.println(toHex(16, 5));
}

private static String toHex(int input, int length) {
    return String.format("%0" + length + "x", input);
}
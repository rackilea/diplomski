public static void main(String[] args) {
    int[] utfCodes = {128531, 128557, 128513};
    String emojis = new String(utfCodes, 0, 3);
    System.out.println("Initial String: " + emojis);

    int[] codePoints = emojis.codePoints().sorted().toArray();
    System.out.println("Sorted String: " + new String(codePoints, 0, 3));
}
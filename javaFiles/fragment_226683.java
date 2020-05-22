public static String decompress(String compressedText) {
    int count = compressedText.length();
    if (count == 0) {
        return "";
    } else if (Character.isDigit(compressedText.charAt(0))) {
        String s = String.format("%0" + compressedText.charAt(0) + "d", 0)
                .replace('0', compressedText.charAt(1));
        return s + decompress(compressedText.substring(2));
    } else if (Character.isLetter(compressedText.charAt(0))) {
        String s3 = Character.toString(compressedText.charAt(0));
        return s3 + decompress(compressedText.substring(1));
    } else
        return compressedText;
}
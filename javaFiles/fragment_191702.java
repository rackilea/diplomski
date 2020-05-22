public static String simplerRewriteBitMask(String token) {
    String input = "0b1111_1111";
    input = input.replace("0b", "");
    input = input.replace("_", "");
    return Integer.toString(Integer.parseInt(input, 2));
}
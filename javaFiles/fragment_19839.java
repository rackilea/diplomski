public static boolean isValidIP4(String address) {
    String block_0_255 = "(0|[1-9]\\d|2[0-4]\\d|25[0-5])";
    String regex = String.format(
            "%s(\\.%s){3}", 
            block_0_255, block_0_255
    );
    return address.matches(regex);
}
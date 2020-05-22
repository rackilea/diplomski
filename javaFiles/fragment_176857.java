public class RadixDetector {

    private static final int RADIX_HEX = 16;
    private static final int RADIX_OCTAL = 8;

    public static int detectRadix(String number) {

        if (number.toLowerCase().startsWith("0x") && isValidHex(number)) {
            return RADIX_HEX;
        } else if (number.startsWith("0") && isValidOctal(number)) {
            return RADIX_OCTAL;
        } else {
            throw new NumberFormatException("Unknown or unable to detect radix for: " + number);
        }
    }

    public static boolean isValidHex(String number) {
        Pattern hexPattern = Pattern.compile("0[xX][0-9a-fA-F]+");
        return hexPattern.matcher(number).matches();
    }

    public static boolean isValidOctal(String number) {
        Pattern hexPattern = Pattern.compile("0[1-7][0-7]*");
        return hexPattern.matcher(number).matches();
    }
}
protected static int toDigit(final char ch, final int index) throws DecoderException {
    final int digit = Character.digit(ch, 16);
    if (digit == -1) {
        throw new DecoderException("Illegal hexadecimal character " + ch + " at index " + index);
    }
    return digit;
}
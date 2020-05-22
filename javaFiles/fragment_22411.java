/**
 * Expects the value to contain a 2-complement number stored in the
 * least significant bits.
 * The contents of the most significant bits is ignored.
 * @param value the value to convert
 * @param bitSize the size of the 2 complement number in the value
 * @return the converted value
 */
public static int fromTwoComplement(int value, int bitSize) {
    int shift = Integer.SIZE - bitSize;
    // shift sign into position
    int result  = value << shift;
    // Java right shift uses sign extension, but only works on integers or longs
    result = result >> shift;
    return result;
}

public static void main(String[] args) {
    System.out.println(fromTwoComplement(0b00_00_0000_0000_0001, 14));
    System.out.println(fromTwoComplement(0b00_01_1111_1111_1111, 14));
    System.out.println(fromTwoComplement(0b00_10_0000_0000_0000, 14));
    System.out.println(fromTwoComplement(0b00_11_1111_1111_1111, 14));

    // largest negative
    byte[] value = new byte[] { 0b0010_0000,  0b0000_0000 };
    System.out.println(fromTwoComplement((int) ByteBuffer.wrap(value).getShort(), 14));

}
public static List<Byte> getNibbles(byte[] bytes) {
    List<Byte> nibbles = new ArrayList<Byte>();

    for (byte b : bytes) {
        nibbles.add((byte) (b >> 4));
        nibbles.add((byte) ((b & 0x0f)));
    }

    return nibbles;
}

public static void main(String[] args) {
    BigInteger i = BigInteger.valueOf(4798234);
    System.out.println(Arrays.toString(i.toByteArray()));
    System.out.println(getNibbles(i.toByteArray()));
}
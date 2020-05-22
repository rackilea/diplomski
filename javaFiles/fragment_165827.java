public static void main(String[] args) throws Exception {
    String bitData = "0101 00001 00001 00010 00011 00101 01000 01101 10101" // 5: 1, 1, 2, 3, 5, 8, 13, 21
                  + " 0011 000 001 010 011 100 101 110 111";                // 3: 0, 1, 2, 3, 4, 5, 6, 7
    BigInteger bi = new BigInteger(bitData.replaceAll(" ", ""), 2);
    System.out.println("0x" + bi.toString(16) + " = 0b" + bi.toString(2));
    byte[] byteData = bi.toByteArray();
    try (BitInputStream in = new BitInputStream(new ByteArrayInputStream(byteData))) {
        int[] nmbrs = readNmbrs(in);
        int[] nmbrs2 = readNmbrs(in);
        System.out.println(Arrays.toString(nmbrs));
        System.out.println(Arrays.toString(nmbrs2));
    }
}
private static int[] readNmbrs(BitInputStream in) throws IOException {
    int[] nmbrs = new int[8];
    int length = in.readInt(4);
    for (int i = 0; i < nmbrs.length; i++)
        nmbrs[i] = in.readInt(length);
    return nmbrs;
}
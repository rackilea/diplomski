public static void main(String[] args) {

    byte b = (byte) 0xA1;
    int last8bits = b & 0xF;

    if (last8bits == 0x01)
        System.out.println("\"matches\"");
}
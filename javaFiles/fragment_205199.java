public static void test() {
    StringBuilder sb = new StringBuilder();
     byte[] byt = new String("stupid interview").getBytes();
     BitSet byt1 = fromByteArray(byt);
     for (int i = 0; i < byt1.size(); i++) {
         sb.append(byt1.get(i) ? "1" : "0");
     }
     String[] st = new String[1];
     st[0] = sb.toString();
     main(st);
}

public static BitSet fromByteArray(byte[] bytes) {
    BitSet bits = new BitSet();
    for (int i=0; i<bytes.length*8; i++) {
        if ((bytes[bytes.length-i/8-1]&(1<<(i%8))) > 0) {
            bits.set(i);
        }
    }
    return bits;
}
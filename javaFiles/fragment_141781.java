BitSet bs = new BitSet(100000000); 
    for (int i = 0; i < 100000000; i++) {bs.set(i);}
    long stDate = System.currentTimeMillis();
    for (int i = 0; (i = bs.nextSetBit(i + 1)) >= 0;) {// TODO}
    long endDate = System.currentTimeMillis();
    System.out.println(endDate - stDate);

    byte[] bytes = new byte[100000000];
    for (int i = 0; i < 100000000; i++) {bytes[i] = 1;}
    stDate = System.currentTimeMillis();
    for (byte b : bytes) {  if (b == 1) // TODO}
    endDate = System.currentTimeMillis();
    System.out.println(endDate - stDate);
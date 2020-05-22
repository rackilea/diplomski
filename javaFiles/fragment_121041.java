private String ParityCalc(String str){
    int input = Integer.parseInt(str,2);
    int[] D = new int[6];
    D[0] = input & (int)0x4b3e37; // Mask for indices 0,1,2,4,5,9,10,11,12,13,16,17,19,22
    D[0] = (Integer.bitCount(D[0])&0x1)^D29; // Parity of masked input XOR D29

// D[1-5] accordingly

    StringBuilder parity = new StringBuilder();
    parity.append(D[0]).append(D[1]).append(D[2]).append(D[3]).append(D[4]).append(D[5]);
    D29 = D[4];
    D30 = D[5];
    return parity.toString();
}
private static String[] staticLookup = new String[]
    {0000,0001,0010,0011,0100,0101,0110,0111,
     1000,1001,1010,1011,1100,1101,1110,1111};


public static String HexToBinary(char Hex) {
    return staticLookup[Integer.parseInt(Character.toString(Hex), 16)];
}
private static void createCharArray(BigInteger value, char[] charSet){
    List<Character> charArray = new ArrayList<Character>();

    BigInteger csSize = BigInteger.valueOf(charSet.length);

    if (value.compareTo(BigInteger.ZERO) == 0)
        charArray.add(0, charSet [0]);
    else{
        BigInteger modded = value.mod(csSize);
        BigInteger digit  = value.divide(csSize);

        while (modded.compareTo(BigInteger.ZERO) != 0 || digit.compareTo(BigInteger.ZERO) != 0){
            if(modded.compareTo(BigInteger.ZERO) == 0){
                charArray.add(0, charSet[csSize.subtract(BigInteger.ONE).intValue()]);
                value = value.subtract(BigInteger.ONE);
            }
            else
                charArray.add(0, charSet[modded.subtract(BigInteger.ONE).intValue()]);
            value = value.divide(csSize);

            modded = value.mod(csSize);
            digit  = value.divide(csSize);
        }
    }

    for(char c : charArray)
        System.out.print(c);
    System.out.println();


}

public static void main(String[] args) {
    long start = System.nanoTime();
    String characters = "";
    characters += "0123456789";
    characters += "abcdefghijklmnopqrstuvwxyz";
    characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    characters += " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    char[] cs = characters.toCharArray();
    Arrays.sort(cs);

    createCharArray(new BigInteger("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"), cs);
    long total = System.nanoTime() - start;
    System.out.println("Completed in: " + total + " billionths of a second");
    System.out.println("Completed in: " + total/1000000 + " thousandth(s) of a second");
}
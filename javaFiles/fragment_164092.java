public static BigInteger readFile() {
    File file = new File ("C:\\number.txt");
    BigInteger n = null;
    try {

        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            n = scan.nextBigInteger();
        }
        scan.close();
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return n;   
}
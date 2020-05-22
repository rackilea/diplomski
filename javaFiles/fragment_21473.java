public static  void encrypt(String plainText) {

    Random random = new Random();

    plainText.toUpperCase();
    char[] storedInput = plainText.toCharArray();
    int[] convertedInput = new int[plainText.length()];


    for (int indexSelector = 0; indexSelector < plainText.length();  indexSelector++) {
    if( storedInput[indexSelector] == ' ') {
        System.out.print(" <SPACE> ");
    } else {
        int converter = storedInput[indexSelector] - 64;
        convertedInput[indexSelector] = converter;
        System.out.print(convertedInput[indexSelector]);
        indexSelector++;
    }
}
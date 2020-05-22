class Main {
    public static void main(String[] args) {
        table(new String[26][26]);
    }

    public static String[][] table(String[][] cipher) {

        String[][] table = {{"abcdefghijklmnopqrstuvwxyz"}};
        for (int i = 0; i < cipher.length; i++) {
            String[] word = table[0];
            cipher[i] = leftShift(word, i);
        }
        return cipher;
    }

    public static String[] leftShift(String[] array, int number) {
        String word = array[0];
        number = number % word.length();
        return new String[]{word.substring(number) + word.substring(0, number)};
    }
}
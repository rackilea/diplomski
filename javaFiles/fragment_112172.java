public static char[] createCipher() { // You weren't using your parameters, so I removed them. You can add them back if you want
    char[] chars = "abcdefghijklmnpoqrstuvwxyz ".toCharArray(); // Add more characters to this string if you need them
    return shuffleArray(chars);
}

public static char[] shuffleArray(char[] array) {
    Random rnd = new Random();
    for (int i = array.length - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1);
        char temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
    return array;
}
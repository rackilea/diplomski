public static int[] indexesOf(String text , char ch) {
    int count = 0;
    for (int i = 0 ; i != text.length() ; i++) {
        if (text.charAt(i) == ch) {
            count++;
        }
    }
    int[] indexes = new int[count];
    int pos = 0;
    for (int i = 0 ; i != text.length() ; i++) {
        if (text.charAt(i) == ch) {
            System.out.println("Found '" + ch + "' at " + i);
            indexes[pos++] = i;
        }
    }
    return indexes;
}
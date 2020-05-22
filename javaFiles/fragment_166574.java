private static int[] alphabet = new int[ROWS];

public static void processLine(String line) {
    line = line.toUpperCase();
    for (int a=0; a < line.length() - 1; a++) {
        char firstLetter = line.charAt(a);
        char secondLetter = line.charAt(a + 1);
        if (firstLetter == secondLetter) {
            alphabet[firstLetter - 65] += 1;
        }
    }
}
private static int[] mangleWord(int[] codePoints) {
    Random rnd = new Random();
    for (int i = codePoints.length - 1; i > 0; i--) {
        int j = rnd.nextInt(i + 1);
        int tmp = codePoints[j];
        codePoints[j] = codePoints[i];
        codePoints[i] = tmp;
    }
    return codePoints;
}
public static String mangleLettersOfWords(String input) {
    int[] codePoints = input.codePoints().toArray();
    for (int i = 0, start = 0; i <= codePoints.length; i++) {
        if (i == codePoints.length || Character.isWhitespace(codePoints[i])) {
            int wordCodePointLen = 0;
            for (int j = start; j < i; j++)
                if (Character.isLetter(codePoints[j]))
                    wordCodePointLen++;
            if (wordCodePointLen != 0) {
                int[] wordCodePoints = new int[wordCodePointLen];
                for (int j = start, k = 0; j < i; j++)
                    if (Character.isLetter(codePoints[j]))
                        wordCodePoints[k++] = codePoints[j];
                int[] mangledCodePoints = mangleWord(wordCodePoints.clone());
                if (mangledCodePoints.length != wordCodePointLen)
                    throw new IllegalStateException("Mangled word is wrong length: '" + new String(wordCodePoints, 0, wordCodePoints.length) + "' (" + wordCodePointLen + " code points)" +
                                                                " vs mangled '" + new String(mangledCodePoints, 0, mangledCodePoints.length) + "' (" + mangledCodePoints.length + " code points)");
                for (int j = start, k = 0; j < i; j++)
                    if (Character.isLetter(codePoints[j]))
                        codePoints[j] = mangledCodePoints[k++];
            }
            start = i + 1;
        }
    }
    return new String(codePoints, 0, codePoints.length);
}
private static int[] mangleWord(int[] codePoints) {
    return mangleWord(new String(codePoints, 0, codePoints.length)).codePoints().toArray();
}
private static CharSequence mangleWord(String word) {
    return new StringBuilder(word).reverse();
}
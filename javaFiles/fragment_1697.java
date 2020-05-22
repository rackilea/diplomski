public static String reverseLettersOfWords(String input) {
    int[] codePoints = input.codePoints().toArray();
    for (int i = 0, start = 0; i <= codePoints.length; i++) {
        if (i == codePoints.length || Character.isWhitespace(codePoints[i])) {
            for (int end = i - 1; ; start++, end--) {
                while (start < end && ! Character.isLetter(codePoints[start]))
                    start++;
                while (start < end && ! Character.isLetter(codePoints[end]))
                    end--;
                if (start >= end)
                    break;
                int tmp = codePoints[start];
                codePoints[start] = codePoints[end];
                codePoints[end] = tmp;
            }
            start = i + 1;
        }
    }
    return new String(codePoints, 0, codePoints.length);
}
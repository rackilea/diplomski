public static void main(String[] args) {
    String strA = "ABGCCFFGTBG";
    String strB = "GECCCDOABG";
    System.out.println("Pattern: " + findPattern(strA, strB));
}

public static String findPattern(String strA, String strB) {
    for (int length = Math.min(strA.length(), strB.length()); length > 0; length--) {
        for (int i = 0; i <= strA.length() - length; i++) {
            String pattern = strA.substring(i, i + length);
            if (strB.contains(pattern)) {
                return pattern;
            }
        }
    }
    throw new NoSuchElementException("No common pattern between " + strA + " and " + strB);
}
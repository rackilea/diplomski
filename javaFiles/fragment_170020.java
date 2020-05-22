public static boolean[][] deepCopy(boolean[][] original) {
    if (original == null) {
        return null;
    }

    final boolean[][] result = new boolean[original.length][];
    for (int i = 0; i < original.length; i++) {
        result[i] = Arrays.copyOf(original[i], original[i].length);
        // For Java versions prior to Java 6 use the next:
        // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
    }
    return result;
}
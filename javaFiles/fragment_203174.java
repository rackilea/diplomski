public static boolean substringWithGaps(String source, String target) {
    int targetIndex = 0;
    for (int i = 0; i < source.length(); i++) {
        if (source.charAt(i) == target.charAt(targetIndex)) {
            targetIndex = targetIndex + 1;
            if (targetIndex == target.length()) {
                return true;
            }
        }
    }
    return false;
}
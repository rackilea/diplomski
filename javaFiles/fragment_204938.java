static boolean isValidSequence(char[] a) {
    for (int i = 0; i < a.length; i++) {
        if (Character.isHighSurrogate(a[i])) {
            if (i < a.length - 1 && Character.isLowSurrogate(a[i + 1])) {
                i++;
            } else {
                return false;
            }
        } else if (Character.isLowSurrogate(a[i])) {
            return false;
        }
    }
    return true;
}
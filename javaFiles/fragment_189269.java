private static List<Integer> palindromes(int digits) {
    return palindromes(digits, 0);
}

private static List<Integer> palindromes(int digits, int shifts) {
    List<Integer> result = new ArrayList<>();
    int radix = (int) Math.pow(10, digits - 1);
    int renaming = digits - 2;
    boolean hasRenaming = renaming > 0;
    for (int i = start(digits, shifts); i <= 9; i++) {
        int high = i * radix;
        int low = low(digits, i);
        if (hasRenaming) {
            for (Integer m : palindromes(renaming, shifts + 1)) {
                int ret = high + m * 10 + low;
                if (ret < 0) {
                    return result;
                }
                result.add(ret);
            }
        } else {
            result.add(high + low);
        }
    }
    return result;
}

private static int low(int digits, int high) {
    return digits > 1 ? high : 0;
}

private static int start(int digits, int shifts) {
    return digits > 1 && shifts == 0 ? 1 : 0;
}
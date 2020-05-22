private static boolean isPermutation(String a, String b) {
    char[] aArray = a.toCharArray();
    char[] bArray = b.toCharArray();

    if (a.length() != b.length()) {
        return false;
    }
    int found = 0;
    for (int i = 0; i < aArray.length; i++) {
        char eachA = aArray[i];
        // check each character in A is found in B
        for (int k = 0; k < bArray.length; k++) {
            if (eachA == bArray[k]) {
                found++;
                bArray[k] = '\uFFFF'; // clear so we don't find again
                break;
            }
        }
    }
    return found == a.length();
}
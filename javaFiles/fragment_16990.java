public static int testClearSet() {
    if (setConatins(50)) {
        myField = 50;
        testSet.clear();
        return myField;
    }
    return -1;
}

private static boolean setConatins(int searchFor) {
    for (Integer n : testSet) {
        if (n == searchFor) {
            return true;
        }
    }
    return false;
}
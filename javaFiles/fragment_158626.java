public static boolean isUniqueChars(String str) {
    long checker1 = 0;
    long checker2 = 0;
    long checker3 = 0;
    long checker4 = 0;
    for (int i = 0; i < str.length(); ++i) {
        int val = str.charAt(i);
        int toCheck = val / 64;
        val %= 64;
        switch (toCheck) {
            case 0:
                if ((checker1 & (1L << val)) > 0) {
                    return false;
                }
                checker1 |= (1L << val);
                break;
            case 1:
                if ((checker2 & (1L << val)) > 0) {
                    return false;
                }
                checker2 |= (1L << val);
                break;
            case 2:
                if ((checker3 & (1L << val)) > 0) {
                    return false;
                }
                checker3 |= (1L << val);
                break;
            case 3:
                if ((checker4 & (1L << val)) > 0) {
                    return false;
                }
                checker4 |= (1L << val);
                break;
        }            
    }
    return true;
}
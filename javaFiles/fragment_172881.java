public static int countMaxOccurence(String s) {
    int digits[] = new int[10];

    for (int i = 0; i < s.length(); i++) {
        int j = s.charAt(i) - 48;
        digits[j]++;
    }

    int digit = 0;
    int count = digits[0];
    for (int i = 1; i < 10; i++) {
        if (digits[i] > count) {
            count = digits[i];
            digit = i;
        }
    }

    System.out.println("digit = " + digit + "  count= " + count);
    return digit;
}
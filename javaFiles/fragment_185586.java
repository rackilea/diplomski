public static int namo(int m) {
    rev_num = 0;
    m = sc.nextInt();
    while (m!= 0) {
        rev_num = rev_num * 10 + m % 10;
        m = m / 10;
    }
    return rev_num;
}
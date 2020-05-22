public date(int a, int b, int c) {
    if (a < 1)
        a = 1;
    if (b < 1)
        b = 1;
    if (c < 1900)
        c = 1900;
    day = a;
    month = b;
    year = c;
}
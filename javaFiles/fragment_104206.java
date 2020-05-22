private static int powerNum(int n, int x) {
    if(x == 0) {
        return 1;
    }
    else {
        return n* powerNum(n, x-1);
    }
}
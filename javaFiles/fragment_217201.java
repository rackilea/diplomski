public static int computeIndex(int n) {
    int i = 1;
    int sum = 0;
    while true {
        sum = sum + i;
        if sum<n {
          i++;
        } else break;
    }
    return i;
}
int filter(int n, int d) {
    if (n >= 0 && d >= 0) {    // n and d non-negetive

        if (n == 0) {   // terminating criteria
            return 0;
        } else {
            int currDigit = n % 10;
            if (n % 10 > d) {
                return filter(n / 10, d) * 10 + currDigit; //gathering digits greater thand d
            } else {
                return filter(n / 10, d);  // ignoring digits less than or equal d
            }
        }

    }
    return -1;
}
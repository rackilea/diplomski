while (n != 1) {
        if (n % 2 == 0) { // true for n == 0
            n = n / 2; // n is still 0
            counter++;
        } else {
            n = (3 * n) + 1;
            counter++;
        }
    }
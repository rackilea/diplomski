public int isPower(int a) {
        if (a == 1) {
            return 1;
        }
        for (long i = 2; i * i <= a; i++) {
            final double value = Math.log(a) / Math.log(i);
            if (value - (int) value < 0.00000001) {
                return 1;
            }
        }
        return 0;
    }
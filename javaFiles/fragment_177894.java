boolean isPrime(int num) {
        int exp = (int) Math.sqrt(num);
        for (int i = 2; i < exp; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
public int nextFactor() {
    for (int i = 2; ; i++) {
        if (num % i == 0) {
            num /= i;
            //System.out.println(i);
            return i;
        }
    }
}
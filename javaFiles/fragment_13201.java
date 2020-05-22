public static void main(String[] args) {
    for (int k = 1; k < 9; k++) {
        for (int p = 1; p <= k; p++) {
            for (int i = 1; i <= p; i++) {
                if (k + p + i == 9) {
                    System.out.println("The 3 numbers that give the sum of 9 are: " + k + p + i);

                }

            }
        }
    }
}
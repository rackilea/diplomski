public static void main(String[] args) {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrayNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 100; i++) {
            int randomNum = (int) (Math.random() * 10);
            for (int j = 0; j < 10; j++) {
                if (arrayNums[j] == randomNum) {
                    count[j]++;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Occurrences of " + i + ": " + count[i]);
        }
    }
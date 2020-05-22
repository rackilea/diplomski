public static int sumNum(int num1, int num2) {
        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
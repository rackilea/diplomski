public static boolean binarySearchNumber(int[] numbers, int number) {
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int lowIndex = 0;
        int highIndex = numbers.length;
        while (lowIndex != highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (numbers[midIndex] == number) {
                return true;
            } else if (numbers[midIndex] < number) {
                lowIndex = midIndex + 1;
            } else if (numbers[midIndex] > number) {
                highIndex = midIndex ; // here
            }
        }
        return false;
    }
public static int[] findMax(int[] allNumbers) {
        int maxValue = allNumbers[0];
        int index = 0;
        for (int i = 1; i < allNumbers.length; i++) {
            if (allNumbers[i] > maxValue) {
                maxValue = allNumbers[i];
                index = i;
            }
        }
        return new int[] {maxValue , index};
}
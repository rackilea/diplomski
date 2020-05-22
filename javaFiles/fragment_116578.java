/**
     * Convert a given string to array of numbers.
     * 
     * @param words
     *            The string
     * @param startValue
     *            The start value for the array.
     * @return The array of numbers.
     */
    public static final int[] wordsToNumbers(String words, int startValue) {
        if (words == null || words.length() == 0) {
            return new int[0];
        } else {
            int[] numbers = new int[words.length()];
            int value = startValue;
            for (int i = 0; i < words.length(); i++) {
                numbers[i] = value;
                value++;
            }
            return numbers;
        }
    }
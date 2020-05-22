public static int[] randomList(int min, int max, int number) {
    // fills an array with all numbers from min to max
    int[] choices = new int[max - min + 1];
    int lastIndex = choices.length - 1;
    for(int i = min; i <= max; i++) {
        choices[i - min] = i;
    }

    // fills the new array with values from choices
    Random r = new Random();
    int[] randomList = new int[number];
    for(int i = 0; i < number; i++) {
        int index = r.nextInt(lastIndex + 1); 
        randomList[i] = choices[index];
        int copy = choices[lastIndex];
        choices[lastIndex] = randomList[i];
        choices[index] = copy;
        lastIndex--;
    }
    return randomList;
}
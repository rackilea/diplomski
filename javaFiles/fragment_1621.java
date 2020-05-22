public static int numberOfMatches(int[] numbers) {
    int mostMatches = 0;

    for(int i = 0; i < numbers.length; i++) {
        int matches = 0;
        int holder = numbers[i];

        for(int number : numbers) {
            if(number == holder) {
                matches++;
            }
        }

        if(matches > mostMatches)
            mostMatches = matches;
    }
    return mostMatches;
}
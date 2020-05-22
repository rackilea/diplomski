public static void main(final String[] s) {
    int counter = 0;
    int highestCount = 0;
    int previousNum = 0;
    int position = 0;
    int latestStartingPosition = 0;
    int startingPosition = 0;

    int inputValue;
    try (final Scanner sc = new Scanner(System.in)) {
        while ((inputValue = sc.nextInt()) != -1) {
            if (previousNum <= inputValue) {
                counter++;
                if (counter > highestCount) {
                    highestCount = counter;
                    startingPosition = latestStartingPosition;
                }
            } else {
                latestStartingPosition = position;
                counter = 1;
            }

            previousNum = inputValue;
            position++;
        }
    }

    System.out.println("starting pos: " + startingPosition);
    System.out.println("Number of repeating positions: " + highestCount);
}
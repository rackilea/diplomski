public static int[] userLottoInput() {
    int[] userNums = new int[6];
    Scanner keyboard = new Scanner(System.in);

    int i = 0;
    // Keep looping until we fill the array, but
    // allow the control to fall somewhere else
    while (i < userNums.length) {

        System.out.printf("Enter Lottery number %d: ", i + 1);
        userNums[i] = keyboard.nextInt();

        // Check for duplicates
        boolean duplicate = false;
        // We only need to check up to i - 1, as all the
        // other values are defaulted to 0
        // We also don't need to check for the last number entered ;)
        for (int k = 0; k < i; k++) {
            // Check for duplicated
            if (userNums[k] == userNums[i]) {
                System.out.println("No duplicates allowed, please try again");
                duplicate = true;
                // Break out of the loop as we don't need to check any more..
                break;
            }
        }

        // If no duplicates where found, update i to the next position
        if (!duplicate) {
            i++;
        }            
    }
    return userNums;
}
private static boolean checkSubList(int[] mainList, int[] subList) {
    int currentIteratingPointer;
    int matchCounter = 0;

    for (int i = 0; i < mainList.length; i++) {
        currentIteratingPointer = i;
        for (int j = 0; j < subList.length; j++) {
            if (mainList[currentIteratingPointer] == subList[j]) {
                System.out.println(mainList[currentIteratingPointer]);
                ++matchCounter;
                ++currentIteratingPointer;
            } else {
                --matchCounter;
                break;
            }
        }

        i = currentIteratingPointer;
    }

    return matchCounter == subList.length; // You can count the number of occurance of the sublist if you change
    // it to int and return the matchCounter a
}
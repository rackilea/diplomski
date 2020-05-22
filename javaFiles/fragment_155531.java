public boolean contains(int[] numbers, int searchedNumber) {
    for (int number : numbers) {
        if (number == searchedNumber) {
            return true;
        }
    }

    return false;
}
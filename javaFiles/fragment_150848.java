private void addToArray(int startIndex, int endIndex) {
    for (int i = startIndex; i < endIndex; ++i) {
        myArray[i] = aNumber + startIndex; // Change is here
        ++aNumber;
    }
}
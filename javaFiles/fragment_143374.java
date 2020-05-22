for (int i = 0; i < numberList.length - 1; i++) {
    if (numberList[i] != numberList[i+1]) {
        noDuplicateList[size] = numberList[i];
        size++;
    }
}
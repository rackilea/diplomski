for(int i = 0; i <= numList.size(); i++) {
    int number1 = numList.get(i);
    int number2 = numList.get(i + 1);
    int sortedArray[];

    if (number1 >= number2) {
        sortedArray[i] = number2;
        numList.set(i + 1,number1);
    } else {
        sortedArray[i] = number1;
        numList.set(i + 1,number2);
    }
}
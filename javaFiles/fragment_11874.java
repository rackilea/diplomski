public int decToBinary(int inputDec) {
    String returnVal = "";
    do {
        returnVal = returnVal + (inputDec % 2);
        inputDec /= 2;
    } while (inputDec > 0);
    return Integer.parseInt(returnVal);
}
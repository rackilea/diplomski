public int sumOf(int terms) {
    int sum = 0;
    for(int i = 0; i < terms; i++){
        sum += getNextTerm();
    }
    return sum;
}
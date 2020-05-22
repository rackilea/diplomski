public int countFrequency(int value) {
    int count = 0;
    for (int num : arr) {
        if (num == value) {
            count++;
        }
    }
    return count;
}
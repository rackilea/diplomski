public void add(int... newNums) {
    for (int num : newNums) {
        sum += num;
        count++;
    }
}
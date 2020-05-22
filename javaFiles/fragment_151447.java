int i = 0;
while (i < nums.size()) {
    if (nums.get(i) == 0) {
        nums.remove(i);
    } else {
        i++;
    }
}
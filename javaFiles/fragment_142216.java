public boolean Stairs() {
    Arrays.sort(collector);
    for (int c = 0; c < collector.length -1; c++) {
        if (collector[c] != collector[c+1] - 1) {
            return false;
        }
    }
    return true;
}
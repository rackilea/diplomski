public String pretty(int num) {
    DecimalFormat f = new DecimalFormat("###.##");
    f.setRoundingMode(RoundingMode.HALF_UP);
    double prettyd = num;
    int count = 0;
    while (prettyd >= 1000.0) {
        prettyd /= 1000.0;
        count++;
    }
    return f.format(prettyd) + getUnit(count);
}
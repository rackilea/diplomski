public double myRound(double val) {
    if (val < 0) {
        return Math.ceil(val);
    }
    return Math.floor(val);
}
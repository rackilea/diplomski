private double raiseDoublePower (double x, double k){
    if (k >= 0) {
        return Math.pow(x, k);
    }
    else {
        return 1 /  Math.pow(x, -k);
    }

}
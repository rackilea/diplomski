public double sigmoid(double x) {
    double sigmoid = 1 / (1 + Math.exp(-x));
    if(sigmoid == Double.NaN)
        System.out.println("1 / (1 + Math.exp(" + (-x) + ")) = " + sigmoid);
    return sigmoid;
}
class ResultContainer {
    double d;
    double f;
    double[] ci;

    public ResultContainer(int y) {
        this.d = 0;
        this.f = 0;
        ci = new double[y];
    }

    public void add(double d, double f, int j, double cij) {
        this.d += d;
        this.f += f;
        ci[j] = cij;
    }

    public void add(ResultContainer resultContainer2) {
        d += resultContainer2.d;
        f += resultContainer2.f;
        for (int j = 0; j < ci.length; j++) {
            // note that one of the two is always 0 here
            ci[j] += resultContainer2.ci[j];
        }
    }
}
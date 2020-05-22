public double[] note(double hz, double duration, double amplitude) {
    int N = (int) (this.SAMPLE_RATE * duration);
    double[] a = new double[N + 1];
    for (int i = 0; i <= N; i++)
        a[i] = amplitude
                * Math.sin(2 * Math.PI * i * hz / this.SAMPLE_RATE);
    return a;
}
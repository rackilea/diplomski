public double[] notes(double hz1, double hz2, double duration, double amplitude) {
    final double[] a1 = note( hz1, duration, amplitude );
    final double[] a2 = note( hz2, duration, amplitude );
    final double[] a3 = new double[a2.length];
    for ( int i = 0; i < a1.length; i++ ) {
        a3[i] = (a1[i] + a2[i]) / 2;       
    }
    return a3;
}
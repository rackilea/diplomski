public static void trimmean(final double[] arr, final int percent) {
    if ( percent < 0 || 100 < percent ) {
        throw new IllegalArgumentException("Unexpected value: " + percent);
    }

    if ( 0 == arr.length ) {
        return Double.NaN;
    }

    final int n = arr.length;
    final int k = Math.round(n * ( percent / 100.0 ) / 2.0); // Check overflow
    final DoubleArrayList list = new DoubleArrayList( arr );
    list.sort();

    return Descriptive.winsorizedMean( list, Descriptive.mean( list ), k, k );
}
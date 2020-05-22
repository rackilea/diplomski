/***
 * Computes MI between variables t and a. Assumes that a.length == t.length.
 * @param a candidate variable a
 * @param avals number of values a can take (max(a) == avals)
 * @param t target variable
 * @param tvals number of values a can take (max(t) == tvals)
 * @return 
 */
static double computeMI(int[] a, int avals, int[] t, int tvals) {
    double numinst = a.length;
    double oneovernuminst = 1/numinst;
    double sum = 0;

    // longs are required here because of big multiples in calculation
    long[][] crosscounts = new long[avals][tvals];
    long[] tcounts = new long[tvals];
    long[] acounts = new long[avals];
    // Compute counts for the two variables
    for (int i=0;i<a.length;i++) {
        int av = a[i];
        int tv = t[i];
        acounts[av]++;
        tcounts[tv]++;
        crosscounts[av][tv]++;
    }

    for (int tv=0;tv<tvals;tv++) {
        for (int av=0;av<avals;av++) {
            if (crosscounts[av][tv] != 0) {
                // Main fraction: (n|x,y|)/(|x||y|)
                double sumtmp = (numinst*crosscounts[av][tv])/(acounts[av]*tcounts[tv]);
                // Log bit (|x,y|/n) and update product
                sum += oneovernuminst*crosscounts[av][tv]*Math.log(sumtmp)*log2;
            }
        }

    }

    return sum;
}
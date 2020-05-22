/**
* Returns the Kullback–Leibler (KL) Divergence, K(p1 || p2).
*
* The log is w.r.t. base 2. <p>
*
* *Note*: If any value in <tt>p2</tt> is <tt>0.0</tt> then the KL-divergence
* is <tt>infinite</tt>. Limin changes it to zero instead of infinite. 
* 
*/
public static double klDivergence(double[] p1, double[] p2) {
    double log2 = Math.log(2);
    double klDiv = 0.0;

    for (int i = 0; i < p1.length; ++i) {
        if (p1[i] == 0) { continue; }
        if (p2[i] == 0.0) { continue; } // Limin

        klDiv += p1[i] * Math.log( p1[i] / p2[i] );
    }

    return klDiv / log2; // moved this division out of the loop -DM
}
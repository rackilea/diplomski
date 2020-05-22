public static double probability(int position, int digit) {   
    double p = 0.0;

    for( int k = Math.pow(10,position-1); k < Math.pow(10,position); k++ {
        p += Math.log( 1+1.0/(k*10 + digit) );
    }

    return p/Math.log(10);
}
public static double assessRandomness(int n){
    int counterLessThan50 = 0;
    for ( int x = 1; x <= n; x++)
        if( (int)(Math.random()*100) <= 50 ) counterLessThan50++;
    return (double) counterLessThan50 / n;
}
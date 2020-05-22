int[] fr = new int[10000];// modified
for( int i = 0; i < Bag.length; i++ ) 
    fr[Bag[i]]++;   // Here
for( int i = 0; i < fr.length; i++ ) { 
    if( fr[i] > 0 ) 
        System.out.println( "The number " + Bag[i] + " occurs " + fr[i] + " time(s).");}}
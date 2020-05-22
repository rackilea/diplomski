// number of flips
    // limit it by 31
    int N = 3;

    // number of combinations
    // using bitshift to power 2
    int NN = 1<<N;

    // array to store combinations
    boolean flips[][] = new boolean[NN][N];

    // generating an array
    // enumerating combinations
    for(int nn=0; nn<NN; ++nn) {

        // enumerating flips
        for( int n=0; n<N; ++n) {

            // using the fact that binary nn number representation
            // is what we need
            // using bitwise functions to get appropriate bit
            // and converting it to boolean with ==
            flips[nn][N-n-1] = (((nn>>n) & 1)==1);

            // this is simpler bu reversed
            //flips[nn][n] = (((nn>>n) & 1)==1);

        }

    }

    // printing an array
    for(int nn=0; nn<NN; ++nn) {

        System.out.print("" + nn + ": ");

        for( int n=0; n<N; ++n) {
            System.out.print(flips[nn][n]?"T ":"F ");
        }
        System.out.println("");
    }
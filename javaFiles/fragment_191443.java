Random rand = new Random();
    int[] diceArray = new int[6];

    int badArrays = 0;
    int nextPosition = 0;

    while ( nextPosition < 6 ) {

        boolean goodMove = true;
        int n = rand.nextInt(6) + 1;
        for ( int i = 0; i < nextPosition; i++ ) {
            if ( diceArray[i] == n ) {
                goodMove = false;
                break;
            }
        }
        if ( goodMove ) {
            diceArray[nextPosition++] = n;
        } else {
            nextPosition = 0;
            badArrays++;
        }
    }

    System.out.println( "Got the array: " + Arrays.toString(diceArray)
                        + " after " + badArrays + " failures." );
n = rand.nextInt();
for ( int i = 0; i < nextPosition; i++ ) {
    if ( diceArray[i] == n ) {
        return;  // Or whatever will cause the array to be disqualified.
    }
}
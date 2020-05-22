for(int z=0; z<5; z ++) {
    x = x + 1;
    if( x > 2 ) { // first half of the OR
        x = x + 1;
    } else {
        // first half of the OR is false, we end up here
        y = y + 1; // pre increment
        if( y > 2 ) {
            x = x + 1;
        }
    }
}
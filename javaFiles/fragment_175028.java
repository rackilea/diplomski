boolean move = false;
do {
    if ( sound.readValue() > 50 ) {
        move = !move;
    }

    while ( sonic.getDistance() > 30 ){
        Motor.B.backward();
        Motor.A.backward();
        Motor.C.backward();
    }
    if (move) {
        Motor.A.rotate( -185, true );
        Motor.C.rotate( 185, true );   
    }
} while( Button.readButtons() != Button.ID_ESCAPE );
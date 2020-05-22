public void addFish(Fish f) {

    if ( landscape[ f.getRow() ][ f.getCol() ] == ROCK ) {
        throw new IllegalFishPositionException(
                IllegalFishPositionException.FISH_OVER_ROCK );
    }

    for ( Fish f1 : this.fish ) {
        // is Fish.equals implemented if so use that.
        if ( f1 == f){

           // fish already in list nothing to do
           // usually bad practice to have return in middle of method
           return; 

        } else if ( ( f1.getRow() == f.getRow() && 
                f1.getCol() == f.getCol() )) {
            throw new IllegalFishPositionException(
                    IllegalFishPositionException.TWO_FISH_IN_ONE_PLACE );
        }
    }

   fish.add( f );

}
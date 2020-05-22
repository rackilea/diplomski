while(rs.next()){
    if (myVolatileBooleanSaysToStop) {
        return; // or whatever
    }
    //do stuff
}
if(randNSEW == 0 && walkgrid[nextrow][nextcol] != '.'){
    //If walker headed west and lands somewhere it has already been
    i--; //Sets the counter back so it won't go further than Z.
    nextcol++; //Moves back in to place.
    mode = Mode.CORRECTING;
    getRandSecundus(); //Calls for secondary random number.
    if(randNSEWS == 0){
        nextrow++; //Check South.
        randNSEW = 1; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 1){
        nextcol++; //Check East.
        randNSEW = 2; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 2){
        nextrow--; //Check North.
        randNSEW = 3; /////////////////////////// THIS LINE ADDED
    }
    continue;
}
if(randNSEW == 1 && walkgrid[nextrow][nextcol] != '.'){
    //If walker headed south and lands somewhere it has already been
    i--; //Sets the counter back so it won't go further than Z.
    nextrow--; //Moves back in to place.
    mode = Mode.CORRECTING;
    getRandSecundus(); //Calls for secondary random number.
    if(randNSEWS == 0){
        nextcol--; //Check West
        randNSEW = 0; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 1){
        nextcol++; //Check East
        randNSEW = 2; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 2){
        nextrow--; //Check North
        randNSEW = 3; /////////////////////////// THIS LINE ADDED
    }
    continue;
}
if(randNSEW == 2 && walkgrid[nextrow][nextcol] != '.'){
    //If walker headed east and lands somewhere it has already been
    i--; //Sets the counter back so it won't go further than Z.
    nextcol--; //Moves back in to place.
    mode = Mode.CORRECTING;
    getRandSecundus(); //Calls for secondary random number.
    if(randNSEWS == 0){
        nextcol--; //Check West
        randNSEW = 0; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 1){
        nextrow++; //Check South
        randNSEW = 1; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 2){
        nextrow--; //Check North
        randNSEW = 3; /////////////////////////// THIS LINE ADDED
    }
    continue;
}
if(randNSEW == 3 && walkgrid[nextrow][nextcol] != '.'){
    //If walker headed north and lands somewhere it has already been
    i--; //Sets the counter back so it won't go further than Z.
    nextrow++; //Moves back in to place.
    mode = Mode.CORRECTING;
    getRandSecundus();
    if(randNSEWS == 0){
        nextcol--; //Check West
        randNSEW = 0; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 1){
        nextrow++; //Check South
        randNSEW = 1; /////////////////////////// THIS LINE ADDED
    }
    if(randNSEWS == 2){
        nextcol++; //Check East
        randNSEW = 2; /////////////////////////// THIS LINE ADDED
    }
    continue;
}
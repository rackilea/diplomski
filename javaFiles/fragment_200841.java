if(collisionDown == false) {
    characterYnext = characterY + fall;          //Get Next Position
    if(NextMovementCollides()){                  //Basically if next position is too far. 
    characterYnext += difference_between(CharacterY,Ground);     //This should move the character to the ground state.
    fall = 0;                                                   //No longer falling so reset the value.
    }
    else{characterY += fall; fall++;}       //Otherwise continue falling like normal.
}
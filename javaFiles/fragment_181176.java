if(aTerm == null || aTerm.isZero()) {
    return;// this is not a valid term
}

int insertIndex = -1; 
int i = 0;
boolean addToList = true;
// loop until you've found your place, make sure to test for end conditions 
// so you don't hit an IndexOutOfBounds error or create an infinite loop
while(insertIndex == -1 && i < theAL.size() && addToList) {
    Term thisTerm = theAL.get(i);
    if(aTerm.degree() == thisTerm.degree()) {
        thisTerm.addIn(aTerm);
        addToList = false;
    } else if(aTerm.degree() > thisTerm.degree()) {
        insertIndex = i;// this will end the loop, we know where to sort 
                        // this element in our array
    }
    i++;// increment our counter
}

if(addToList) {
    // make sure we found a valid location, if so, add in our term
    if(insertIndex >= 0) {
        theAL.add(insertIndex, aTerm);
    } else {
        theAL.add(aTerm); // insert the term at the end, it's less than all 
                          // other terms in the list, or the list is empty
    }
}
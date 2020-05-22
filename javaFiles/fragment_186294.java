public T getUnique(){
    T distinct = null;
    int count = 0; // FIXME: move this initialization inside the i loop
    for (int i=0; i<vals.length; i++){
        distinct =  vals[i];
        for (int j = 0; j<vals.length; j++){
            if (vals[j] == vals[i]){ // FIXME: use .equals() not ==
                count++;
            }
            if (count == 1){ // FIXME: move this check outside the j loop
                return distinct;
            }
        }
    }
    if (distinct == null){ //FIXME: no check needed, just throw it
        throw new IllegalArgumentException();
    }
    return distinct; //FIXME: no valid return can reach this point
}
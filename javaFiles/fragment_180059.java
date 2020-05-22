public boolean isCarOwned(String pName) {   //find Car in Array with pName
    for(int x = 0; x < carCount; x++) {     // carCount = array length
        if(carInv[x] != null && carInv[x].equals(pName)) { // if x-th value is not null and is equal to pName
                return true;
        }
    }
    return false;
}
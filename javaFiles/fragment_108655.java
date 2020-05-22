if (averagePrice == -1) {
    if (otherRestaurant.averagePrice != -1)
        return false;
}   
    else if (averagePrice != (otherRestaurant.averagePrice)) // change to != here
        return false;
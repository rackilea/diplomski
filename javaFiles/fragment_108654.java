if (this.getName() == null) {
    if (otherRestaurant.getName() != null)
        return false;
}   else if (!super.getName().equals(otherRestaurant.getName())) // added ! here
        return false;

if (peopleServed == -1) {
    if (otherRestaurant.peopleServed != -1)
        return false;
}   else if (peopleServed != (otherRestaurant.peopleServed)) // change to != here
        return false;

if (averagePrice == -1) {
    if (otherRestaurant.averagePrice != -1)
        return false;
}   
    else if (averagePrice != (otherRestaurant.averagePrice)) // change to != here
        return false;

//No differences, then it is equals.
return true;
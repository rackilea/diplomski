public boolean equals (Object rhs) {          
    if (this == rhs) { 
        return true; 
    }          
    if (!(rhs instanceof Building)) { 
        return false; 
    }          
    Building b = (Building) rhs;     

    // This is what you're supposed to add. It will return true only if both
    // object's attributes (name and number of floors) are the same
    return this.name.equals(b.name) && this.noOfFloors == b.noOfFloors;
}
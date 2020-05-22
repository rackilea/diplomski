public boolean containsNullObject(Object... objs) {
    // loop through each string
    for(Object o : objs) {
        if(s == null) { return false; } // return false if string is null
    }
    // if there was no instance of a null object, return true
    return true;
}
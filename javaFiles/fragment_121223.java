// before
public Map<Integer, User>() getNames() { 
    // query the db
    // create the map
    return names; 
}

// after: the method was to slow, cache the result
public Map<Integer, User>() getNames() { 
    if (this.names == null) {
        // query the db
        // create the map
    }
    return this.names; 
}
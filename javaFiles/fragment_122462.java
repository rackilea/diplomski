public bool myMethod() {
    bool summaryCondition = myMethodWork();
    // do common code
    return summaryCondition;
}

private bool myMethodWork() {
   /* ... code ... */

    if(thisCondition) {
        return false;
    }

    /* ... more code ... */

    if(thatCondition) {
        return false;
    }

    /* ... even more code ... */

    return lastCondition;
}
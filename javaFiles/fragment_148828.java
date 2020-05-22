CommercialObject obj = null;
try { 
    obj = (CommercialObject)pool.borrowObject();

    // use the commerical object the way you to use it.
    // ....

} finally { 
    // be nice return the borrwed object
    try {
        if(obj != null) {
            pool.returnObject(obj);
        }
    } catch(Exception e) {
        // ignored
    }
}
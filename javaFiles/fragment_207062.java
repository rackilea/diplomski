catch(MongoWriteException ex) {
    if(ex.getError().getCategory() == ErrorCategory.DUPLICATE_KEY) {
        //handle duplicate key error
    } else {
        //do something else...
    }
}
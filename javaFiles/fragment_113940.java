try {
    // call the method in question
} catch (MyCustomException mce) {
    if(mce.getErrorCode() == some_error_code) {
        // do stuff
    }
}
DefaultResponse errorResponse = null
try {
    // some code
    if (voidResult.errorGenerated()) {
        errorResponse = new DefaultResponse();
    }
} catch (Exception e) { 
    // deal with error
}
if (errorResponse != null) {
    throw new ResponseError////
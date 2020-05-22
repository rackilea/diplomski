UserAtWrongPlaceException exception = null;
if(response.check() == checkNumber) {
    String message = "You are looking at Wrong Place";
    logger.log(message);
    exception = new UserAtWrongPlaceException(message);
}
...
if(response.check() == somethingElse) { ... }
...
if(exception != null) {
    throw exception;
}
return true;
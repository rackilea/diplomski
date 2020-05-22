try {
    if(response.check() == checkNumber) {
        String message = "You are looking at Wrong Place";
        logger.log(message);
        throw new UserAtWrongPlaceException(message);
    }
} catch(UserAtWrongPlaceException e) {
    //Do something with the exception, or just ignore it.
}
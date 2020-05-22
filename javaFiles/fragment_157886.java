} catch (ExecutionException e){
    if(e.getCause() instanceof InternalServerException) {
        //handle internal server error
    } else if(e.getCause() instanceof ResourceNotFoundException) {
        //handle resource not found
    }
}
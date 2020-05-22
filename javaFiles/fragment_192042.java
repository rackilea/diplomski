static class OnResourceNotFoundExceptionStopStrategy implements StopStrategy {

    @Override
    public boolean shouldStop(Attempt attempt) {
        if (attempt.hasException() 
                     && attempt.getExceptionCause() instanceof ResourceNotFoundException) {
            return true;
        }
        return false;
    }

}
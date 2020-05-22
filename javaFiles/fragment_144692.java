@Override
protected void run() {
    try {
        validator.validate(user);
        // Save user somehow
    } catch(BadEntityException bexc) {
        log.error(bexc);
        throw new HystrixBadRequestException("Hystrix caught a bad request.", bexc);
    }
}
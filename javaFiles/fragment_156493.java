@RequestMapping(value = "/user", method = RequestMethod.POST)
public Mono<ResponseEntity<Integer>> createUser(@RequestBody ImUser user) {
    //this log as you saw was executed in the same thread as the controller method
    logger.debug("Receiving request on thread: " + Thread.currentThread().getName());
    return userService.create(user)
        .map(it -> {
            logger.debug("Sending response on thread: " + Thread.currentThread().getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(it);
        })
        .mapError(DuplicateKeyException.class, e -> new SomeSpecialException(e.getMessage(), e));
}
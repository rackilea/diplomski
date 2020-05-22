@RequestMapping(value = "/url", method = RequestMethod.GET)
public CompletableFuture<ResponseEntity> url() {
  return CompletableFuture.supplyAsync(() -> {
    // do your computations here
  });
}
@GetMapping("/test")
public Mono<User> showUser() {
  throw new IllegalStateException("error message!);
}


@GetMapping("/test")
public Mono<User> showUser() {
  return Mono.error(new IllegalStateException("error message!));
}
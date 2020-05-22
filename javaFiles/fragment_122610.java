@Test
public void monoError() {
  Flux<String> monoError = Mono.just("HelloWorld")
      .concatWith(Mono.error(new RuntimeException("error")))
      .log();          ;
  StepVerifier.create(monoError)
      .expectNext("HelloWorld")
      .expectErrorMessage("error")
      .verify();
}
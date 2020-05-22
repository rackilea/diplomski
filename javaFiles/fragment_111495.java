@Configuration 
class SchedulersConfig {

  @Bean
  Scheduler parallelScheduler(@Value("${blocking-thread-pool-size}") int threadsCount) {
    return Schedulers.parallel(threadsCount);
  }
}

@RestController
class Controller {

  final Scheduler parallelScheduler;

  ...

  Mono<User> userResponse = // webClient...

  Mono<Iterable<Product>> productsResponse = Mono.fromSupplier(productRepository::findAll)
    .subscribeOn(parallelScheduler); 

  return Mono.zip(userResponse, productsResponse, (user, products) -> 
    new ModelAndView("messages/list", 
      ImmutableMap.of(
        "userState", new UserState(userRequest, user),
        "products", products
      ))
  );
}
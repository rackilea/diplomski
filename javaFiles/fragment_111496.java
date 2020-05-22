Map<String, Object> models = new HashMap<>();
Mono<User> userMono = webClient...;
CompletableFuture<User> userFuture = userMono.toFuture();
Iterable<Product> messages = productRepository.findAll();
User user = userFuture.join();
models.put("products", messages);
models.put("userState", new UserState(userRequest, user));
return new ModelAndView("messages/list", models);
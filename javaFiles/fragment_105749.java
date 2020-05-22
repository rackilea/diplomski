public Mono<ServerResponse> getMemberDetails(ServerRequest request) {
  String id = request.pathVariable("id");

   Mono<PlanDetails> userMono = repository.findById(id);
   Mono<ServerResponse> notFound = ServerResponse.notFound().build();

   return userMono
       //transform from user mono to Flux of member details
       .flatMap(user -> Flux.fromArray(user.member)) //if `member` is an Iterable use the following instead:
       //.flatMapIterable(user -> user.member)
       //now we have a Flux of member IDs, go get details
       .flatMap(repository::findById)
       //this will naturally ignore not found members
       //if no member is found or array of IDs is empty, the main sequence is itself empty at this point
       .switchIfEmpty(notFound);
}
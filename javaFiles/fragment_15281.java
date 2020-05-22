ActorRepository.findByActorNameIn(
    movie.getActors()
         .stream()
         .map(Actor::getName)
         .collect(Collectors.toList())
);
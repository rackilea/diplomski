private Feeder feederFor(Animal animal) {
    return feeders.stream()
                  .filter(feeder -> feeder.canFeed(animal))
                  .findFirst()
                  .orElse((Feeder) unknownAnimal -> {});
}
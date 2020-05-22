@Autowired
private List<Feeder<? extends Animal>> feeders;

public void feed(Animal animal) {
    feederFor(animal).feed(animal);
}

private Feeder feederFor(Animal animal) {
    return feeders.stream()
                  .filter(feeder -> feeder.canFeed(animal))
                  .findFirst()
                  .orElse(unknownAnimal -> {});
}
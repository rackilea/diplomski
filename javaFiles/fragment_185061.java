private Feeder feederFor(Animal animal) {
    return feederMap.entrySet().stream()
                    .filter(entry -> canFeed(entry.getKey(), animal))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse((Feeder) unknownAnimal -> {});
}
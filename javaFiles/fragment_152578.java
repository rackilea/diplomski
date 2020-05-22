Enclosure enclosure = new Enclosure();
// enclosure is populated with animals

// each month...
final Set<Class<? extends Animal>> allSpecies = enclosure.getSpecies();
for (Class<? extends Animal> species : allSpecies) {
    final List<Animal> females = enclosure.getFemales(species);
    final List<Animal> males = enclosure.getFemales(species);
    for (Animal male : males) {
        for (Animal female : females) {
            final Optional<Animal> maybeOffspring = male.gender.apply(male,
                                                                    female);
            maybeOffspring.ifPresent(enclosure::add);
        }
    }
}
private Set<Dog> dogsOwned;

public DogOwner(String name) {
    this.name = name;
    this.dogsOwned = new HashSet<>();  // new HashSet<Dog>() Java 7-
}
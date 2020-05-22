class Ladder {
  private List<Animal> animalsOnLadder = new ArrayList<Animal>;

  public Ladder() {
    placeAnimalOnLadder(new eagle());
    placeAnimalOnLadder(new squirell());

  }

  public void placeAnimalOnLadder(Animal animal) {
    animalsOnLadder.add(animal);
  }

}
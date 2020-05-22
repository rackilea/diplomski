class AnimalList<AnimalType extends Animal> extends List<AnimalType> {
   void mate() {
      Class<AnimalType> firstAnimalInstanceClass = animals.get(0).getClass();
      AnimalType newAnimal = (AnimalType)firstAnimalInstanceClass.newInstance();
      add(newAnimal);
   }
}
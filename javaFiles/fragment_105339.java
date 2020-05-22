for (Animal animal : animals) {
  // Calls overriden method
  animal.makeSound();
  // This is illegal. Method getCatProperty is not declared in Animal  
  animal.getCatProperty();
  // This is illegal. Method getDogProperty is not declared in Animal class
  animal.getDogProperty();

  /*
   * IF YOU HAVE TO CALL CHILD CLASS SPECIFIC METHODS, DO IT LIKE THIS:
   */

  // Checks if animal is of type Cat
  if (animal instanceof Cat) {
    // Casts animal to instance of Cat
    Cat cat = (Cat) animal;
    // Calls specific Cat instance method
    System.out.println(cat.getCatProperty());
  }

  // Checks if animal is of type Dog
  if (animal instanceof Dog) {
    // Casts animal to instance of Dog
    Dog dog = (Dog) animal;
    // Calls specific Dog instance method
    System.out.println(dog.getDogProperty());
  }
}
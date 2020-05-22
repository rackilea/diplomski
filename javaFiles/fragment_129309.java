public Farm(Class<? extends Animal> animalType, int n)
       throws ReflectiveOperationException {
    System.out.println("Multiple animal constructor called...");
    for (int i = 0; i < n; i++) {
        farmlist.add(animalType.newInstance());
    }
}
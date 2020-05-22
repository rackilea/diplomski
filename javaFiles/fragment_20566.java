public void initialisePets(){
    final Supplier<Pet> supplier = getPet();

    pet1 = supplier.get();
    pet2 = supplier.get();
}
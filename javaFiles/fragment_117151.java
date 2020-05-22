public Pet(Pet copy) {
    this();
    if(copy != null) {
        newPet(copy);
    }
}
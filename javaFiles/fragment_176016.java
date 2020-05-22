public Person getMother() {
    if (mother == null) {
        mother = new Person("Eva");
    }
    return mother;
}
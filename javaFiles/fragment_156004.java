public Clas createClas() {
    Clas c = new Clas();
    // call setters to populate the clas
    entityManager.persist(c);
    return c;
}
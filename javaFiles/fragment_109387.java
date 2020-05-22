enum AnimalType {
    CAT(new CatWriter());

    private Writer<? extends Animal> writer;

    AnimalType(Writer<? extends Animal> writer) {
        this.writer = writer;
    }

    public Writer<Animal> getWriter() {
        return (Writer<Animal>)writer;
    }
}
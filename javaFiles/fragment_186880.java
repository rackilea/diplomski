class Model {
    String name;
    int counter;

    Model(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public String toString() {
       return name;
    } 
}
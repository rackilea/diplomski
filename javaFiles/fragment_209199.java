class Foo implements PeekerView<T>{

    private Peeker<T> peeker = new PeekerImpl();

    public Peeker<T> getPeeker() {
        return peeker;
    }

}
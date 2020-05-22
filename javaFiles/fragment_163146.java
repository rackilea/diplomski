class Store {

    private Car ferrari = new Ferrari();
    private Car lamborghini = new Lamborghini();

    public Car getFerrari() {
        return ferrari;
    }

    public void setFerrari(Car ferrari) {
        this.ferrari = ferrari;
    }

    public Car getLamborghini() {
        return lamborghini;
    }

    public void setLamborghini(Car lamborghini) {
        this.lamborghini = lamborghini;
    }
}
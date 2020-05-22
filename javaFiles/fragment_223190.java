class Thing {
    //Some external Dependency which provides the method 'int doWork()'
    private Dependency dependency;
    private int value;
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
    public int getValue() {
        return value;
    }
    // Calculates something depending on the provided amount.
    public void calculate(int amount) {
        for(int i = 0; i < amount; i++) {
            value += dependency.doWork();
        }
    }
}
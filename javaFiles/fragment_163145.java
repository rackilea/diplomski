class Manager<T extends Car> {

    private Class<T> clazz;

    public Manager(Class<T> clazz) {
        this.clazz = clazz;
    }

    public String generateCustomCarName() {
        if (Lamborghini.class == clazz) {
            return "Lambooooo!";
        } else if (Ferrari.class == clazz) {
            return "Wild horse Ferrari!";
        }

        return "Not for everyone!";
    }

    @Override
    public String toString() {
        return String.format("Manager[clazz=%s]", clazz.getName());
    }
}
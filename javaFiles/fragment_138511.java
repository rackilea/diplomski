public enum Company {

    AUDI(4), BMW(5), CADILLAC(11), FORD(44), JAGUAR(45), ...;

    private final int id;

    private Company(int id) {
        this.id = id;
    }
}
class Project {
    String id;
    Unit unit;
    public Project(final String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return this.id + ": unit = " + this.unit.id;
    }
}
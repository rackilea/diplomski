class Person implements Comparable<Person> {
    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    private String name;
    private double weight;

    @Override
    public int compareTo(Person o) {
        int r = Double.compare(this.weight, o.weight);
        if (r != 0) {
            return r;
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Weight: %.1f", name, weight);
    }
}
public class PersonStatistics {
    private long firstNameCounter;
    private int maxAge = Integer.MIN_VALUE;
    private double minHeight = Double.MAX_VALUE;
    private double totalWeight;
    private long total;
    private final Predicate<Person> firstNameFilter;

    public PersonStatistics(Predicate<Person> firstNameFilter) {
        Objects.requireNonNull(firstNameFilter);
        this.firstNameFilter = firstNameFilter;
    }

    public void accept(Person p) {
        if (this.firstNameFilter.test(p)) {
            firstNameCounter++;
        }

        this.maxAge = Math.max(p.getAge(), maxAge);
        this.minHeight = Math.min(p.getHeight(), minHeight);
        this.totalWeight += p.getWeight();
        this.total++;
    }

    public PersonStatistics combine(PersonStatistics personStatistics) {
        this.firstNameCounter += personStatistics.firstNameCounter;
        this.maxAge = Math.max(personStatistics.maxAge, maxAge);
        this.minHeight = Math.min(personStatistics.minHeight, minHeight);
        this.totalWeight += personStatistics.totalWeight;
        this.total += personStatistics.total;

        return this;
    }

    public Object[] toStatArray() {
        return new Object[]{firstNameCounter, maxAge, minHeight, total == 0 ? 0 : totalWeight / total};
    }
}
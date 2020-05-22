public abstract class ChartEnricher {

    private final String name;

    protected ChartEnricher(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public abstract void enrichChart();

    @Override
    public String toString() {
        return name;
    }
}
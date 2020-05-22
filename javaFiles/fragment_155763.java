public class Element {
    private int atomicNumber;
    private String name;
    private String symbol;
    private int group;
    private int period;

    public Element(int atomicNumber, String name, String symbol, int group, int period) {
        this.atomicNumber = atomicNumber;
        this.name = name;
        this.symbol = symbol;
        this.group = group;
        this.period = period;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getGroup() {
        return group;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "Element [atomicNumber=" + atomicNumber + ", name=" + name + ", symbol=" + symbol
                + ", group=" + group + ", period=" + period + "]";
    }

}
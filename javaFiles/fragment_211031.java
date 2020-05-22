public enum Type {
boObject("BO-Objekt", new Indicator("Test1"), new Indicator("Test2"), new Indicator("Test3")),
job("Job", new Indicator("Test1"), new Indicator("Test2")),
table("Tabelle", new Indicator("Test1")),
tableColumn("Tabellenspalte", new Indicator("Test1"), new Indicator("Test2"));

private String displayName;
private Indicator[] indics;

private Type(String displayName, Indicator ... indics) {
    this.displayName = displayName;
    this.indics = indics;
}

@Override public String toString() {
    return displayName;
}

public Indicator[] getIndics() {
    return indics;
}

public void setIndics(Indicator[] indics) {
    this.indics = indics;
}
}
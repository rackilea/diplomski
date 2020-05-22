public class Parameters {
    private LinkedHashSet<String> namesSet = null;
    private LinkedHashSet<Locale> localesSet = null;

    public Parameters(LinkedHashSet<String> namesSet, LinkedHashSet<Locale> localesSet) {
        this.namesSet = namesSet;
        this.localesSet = localesSet;
    }

    public Parameters() {
    }

    public LinkedHashSet<String> getNamesSet() {
        return namesSet;
    }

    public void setNamesSet(LinkedHashSet<String> namesSet) {
        this.namesSet = namesSet;
    }

    public LinkedHashSet<Locale> getLocalesSet() {
        return localesSet;
    }

    public void setLocalesSet(LinkedHashSet<Locale> localesSet) {
        this.localesSet = localesSet;
    }
}
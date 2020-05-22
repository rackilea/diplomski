public abstract class AbstractTableConfigurationBuilder
                      <T extends AbstractTableConfigurationBuilder<T>> {

    public T filterable() {
        // set filterable flag
        return (T) this;
    }

    public T paginated() {
        // set paginated flag
        return (T) this;
    }

    public T sortable() {
        // set sortable flag
        return (T) this;
    }

    public T withVeryStrangeSetting() {
        // set very strange setting flag
        return (T) this;
    }

    // TODO add all possible settings here

    public TableConfiguration build() {
        // build object with all settings and return it
    }
}
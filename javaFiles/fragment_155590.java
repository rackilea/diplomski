public class ExampleStringProperty {

    private final List<ChangeListener<? super String>> changeListeners
        = new ArrayList<>();

    private String value ;

    public String get() {
        return value ;
    }

    public void set(String value) {
        if (! Objects.equals(value, this.value)) {
            String oldValue = this.value ;
            this.value = value ;
            for (ChangeListener<? super String> listener : changeListeners) {
                listener.changed(this, oldValue, value);
            }
        }
    }

    public void addListener(ChangeListener<? super String> listener) {
        changeListeners.add(listener);
    }

    public void removeListener(ChangeListener<? super String> listener) {
        changeListeners.remove(listener);
    }
}
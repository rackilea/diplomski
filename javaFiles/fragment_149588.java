public class Wrapper<V> {

    private Field<V> field;

    private LabelProvider<V> labelProvider; // Converts from V to String

    // Since we have no guarantee that F has a LabelProvider, one is explicitely
    // supplied.
    public Wrapper(Field<V> field, LabelProvider<V> labelProvider) {
        this.field = field;
        this.labelProvider = labelProvider;
    }

    public Wrapper(LabelField<V> labelField) {
        // Use the field's own label provider
        this(labelField, labelField.getLabelProvider());
    }

    private String getLabel() {
        return this.labelProvider.getLabel(this.field.getValue());
    }

    public Field<V> getField() {
        return this.field;
    }

    public V getValue() {
        return this.field.getValue();
    }
}
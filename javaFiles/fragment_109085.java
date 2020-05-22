public class EnumEditor extends FlowPanel implements LeafValueEditor<E> {

    private Map<RadioButton, E> map;

    @UiConstructor
    public EnumEditor(String groupName) {
        map = new HashMap<RadioButton, E>();
        for (E e: E.class.getEnumConstants()){
            RadioButton rb = new RadioButton(groupName, e.name());
            map.put(rb, e);
            super.add(rb);
        }
    }

    @Override
    public void setValue(E value) {
        if (value==null)
            return;
        RadioButton rb = (RadioButton) super.getWidget(value.ordinal());
        rb.setValue(true);
    }

    @Override
    public E getValue() {
        for (Entry<RadioButton, E> e: map.entrySet()) {
            if (e.getKey().getValue())
                return e.getValue();
        }
        return null;
    }
}
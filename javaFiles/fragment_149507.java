public class Item {
    private final int i;
    private final BooleanProperty keep = new SimpleBooleanProperty();

    public Item(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    public BooleanProperty keepProperty() {
        return keep;
    }

    public boolean isKeep() {
        return keep.get();
    }

    public void setKeep(boolean value) {
        keep.set(value);
    }

}
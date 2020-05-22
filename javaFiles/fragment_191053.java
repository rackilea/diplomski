public class Item implements Serializable {
    private StringProperty name ;
    private IntegerProperty value ;
    private BooleanProperty active ;

    public Item(String name, int value, boolean active) {
        this.name = new SimpleStringProperty(name) ;
        this.value = new SimpleIntegerProperty(value);
        this.active = new SimpleBooleanProperty(active);
    }


    public final StringProperty nameProperty() {
        return this.name;
    }
    public final java.lang.String getName() {
        return this.nameProperty().get();
    }
    public final void setName(final java.lang.String name) {
        this.nameProperty().set(name);
    }
    public final IntegerProperty valueProperty() {
        return this.value;
    }
    public final int getValue() {
        return this.valueProperty().get();
    }
    public final void setValue(final int value) {
        this.valueProperty().set(value);
    }
    public final BooleanProperty activeProperty() {
        return this.active;
    }
    public final boolean isActive() {
        return this.activeProperty().get();
    }
    public final void setActive(final boolean active) {
        this.activeProperty().set(active);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(getName());
        out.writeInt(getValue());
        out.writeBoolean(isActive());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = new SimpleStringProperty((String)in.readObject());
        this.value = new SimpleIntegerProperty(in.readInt());
        this.active = new SimpleBooleanProperty(in.readBoolean());
    }

    // Quick test:
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Item testItem = new Item("Item", 42, true);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(testItem);
        oos.close();
        byte[] bytes = out.toByteArray();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Item result = (Item) in.readObject();
        System.out.println(result.getName());
        System.out.println(result.getValue());
        System.out.println(result.isActive());
    }
}
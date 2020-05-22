public class EventsBean implements Serializable {


    private transient SimpleStringProperty event;
    private transient SimpleObjectProperty<LocalDate> date;
    private transient SimpleStringProperty done;
    private transient SimpleStringProperty observation;
    private transient SimpleBooleanProperty selected;

    // constructors...

    // example get/set/property methods:
    public StringProperty eventProperty() {
        return event ;
    }

    public final String getEvent() {
        return eventProperty().get();
    }

    public final void setEvent(String event) {
        eventProperty().set(event);
    }

    // etc. for other properties...


    // custom serialization:
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(getEvent()); // write event as a plain String
        s.writeObject(getDate()); 
        s.writeObject(getDone());
        s.writeObject(getObservation());
        s.writeBoolean(isSelected());
    }

    // custom deserialization:
    private void readObject(ObjectInputStream s) throws IOException {
        s.defaultReadObject();
        this.event = new SimpleStringProperty((String)s.readObject());
        this.data = new SimpleObjectProperty<>((LocalDate)s.readObject());
        this.done = new SimpleStringProperty((String)s.readObject());
        this.observation = new SimpleStringProperty((String)s.readObject());
        this.selected = new SimpleBooleanProperty(s.readBoolean());
    }
}
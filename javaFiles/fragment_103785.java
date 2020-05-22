public class Domain {
    private final BooleanProperty completed ;

    public Domain(boolean completed) {
        this.completed = new SimpleBooleanProperty(completed);
    }

    public BooleanProperty completedProperty() {
        return completed ;
    }

    public final boolean isCompleted() {
        return completedProperty().get();
    }

    public final void setCompleted(boolean completed) {
        completedProperty().set(completed);
    }
}
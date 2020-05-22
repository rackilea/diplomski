public class Model {

    private final StringProperty position = new SimpleStringProperty("None");

    public StringProperty positionProperty() {
        return position ;
    }

    public final String getPosition() {
        return positionProperty().get();
    }

    public final void setPosition(String position) {
        positionProperty().set(position);
    }
}
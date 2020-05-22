public class FillEmoticon {

    // code exactly as you have, except for get/setFill

    public ObjectProperty<Paint> fillProperty() {
        return filled.fillProperty();
    }

    public final void setFill(Paint fill) {
        fillProperty().set(fill);
    }

    public final Paint getFill() {
        return fillProperty().get();
    }

}
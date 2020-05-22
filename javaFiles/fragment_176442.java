public class FillEmoticon {

    public StringProperty fill = new SimpleStringProperty();

    public StringProperty fillProperty() {
        return fill ;
    }

    public final String getFill() {
        return fillProperty().get();
    }

    public final void setFill(String fill) {
        fillProperty().set(fill);
    }

    public FillEmoticon() {
        // ...
        fill.addListener((obs, oldFill, newFill) -> filled.setFill(Paint.valueOf(newFill)));

    }

    // ...
}
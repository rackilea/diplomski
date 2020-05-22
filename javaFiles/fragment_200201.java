public class TranslatedWord {

    private final StringProperty id = new SimpleStringProperty();

    public StringProperty idProperty() {
        return id ;
    }
    public final String getId() {
        return idProperty().get();
    }
    public final void setId(String id) {
        idProperty().set(id);
    }

    private final StringProperty english = new SimpleStringProperty();

    public StringProperty englishProperty() {
        return english ;
    }
    public final String getEnglish() {
        return englishProperty().get();
    }
    public final void setEnglish(String english) {
        englishProperty().set(english);
    }

    private final StringProperty bangla = new SimpleStringProperty();

    public StringProperty banglaProperty() {
        return bangla ;
    }
    public final String getBangla() {
        return banglaProperty().get();
    }
    public final void setId(String bangla) {
        banglaProperty().set(bangla);
    }

}
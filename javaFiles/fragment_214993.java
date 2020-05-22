public class Article {
    private ObjectProperty<LocalDateTime> dateTime = new SimpleObjectProperty<>();
    public final ObjectProperty<LocalDateTime> dateTimeProperty() {
         return dateTime;
    }
    public void setDateTime(LocalDateTime ldt) {
         dateTime.set(ldt);
    }
    public LocalDateTime getDateTime() {
         return dateTime.get();
    }
}
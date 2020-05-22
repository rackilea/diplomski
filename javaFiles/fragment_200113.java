public class Appointment {
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    public final LocalDate getDate() {
        return this.date.get();
    }

    public final void setDate(LocalDate value) {
        this.date.set(value);
    }

    public final ObjectProperty<LocalDate> dateProperty() {
        return this.date;
    }
}
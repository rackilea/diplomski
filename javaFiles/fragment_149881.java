@JsonSerialize(using = CustomSerializer.class)
public class MyClass {

    private DateTime dateTime = new DateTime();
    ...

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
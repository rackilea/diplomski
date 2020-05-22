public class Toto {

    public Optional<Date> myDate;

    public Optional<Date> getMyDate() {
        return this.myDate;
    }

    public void setMyDate(final Date myDate) {
        this.myDate = Optional.ofNullable(myDate);
    }

}
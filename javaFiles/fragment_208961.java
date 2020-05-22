public class Toto {


    public Date myDate;

    public Optional<Date> getMyDate() {
        return Optional.ofNullable(this.myDate);
    }

    public void setMyDate(final Date myDate) {
        this.myDate = myDate;
    }

}
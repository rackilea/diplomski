public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private PickedDate birthday;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String pLastName) {
        lastName = pLastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String pPhoneNumber) {
        phoneNumber = pPhoneNumber;
    }
    public PickedDate getBirthday() {
        return birthday;
    }
    public void setBirthday(PickedDate pBirthday) {
        birthday = pBirthday;
    }
    public static class PickedDate {
        private final ObservableInt year;
        private final ObservableInt month;
        private final ObservableInt day;
        public PickedDate() {
            year = new ObservableInt();
            month = new ObservableInt();
            day = new ObservableInt();
        }
        public ObservableInt getYear() {
            return year;
        }
        public ObservableInt getMonth() {
            return month;
        }
        public ObservableInt getDay() {
            return day;
        }
    }
}
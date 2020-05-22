public interface MyBirthdayEvent {
    void itsMyBirthday();

    default void invoke() {
        itsMyBirthday();
    }
}
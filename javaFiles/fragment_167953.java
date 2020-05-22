public class PhoneNumber {

    private final String number;

    public PhoneNumber(String number) {
        if (number == null || !number.matches("\\d+([-]\\d+)?")) {
            throw new .....
        }
        this.number = number;
    }
}
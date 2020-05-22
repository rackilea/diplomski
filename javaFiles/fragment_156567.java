public class Booking {
    public enum Status { NEW, PROGRESS, SUCCESS, FAILED }

    private Status status;

    public Status getStatus() {
        return status;
    }
}
public class NonDuplicateAttendance {

    public  long value;

    public NonDuplicateAttendance() { }

    public NonDuplicateAttendance(long value) {
        this.value = value;
    }

    @Exclude
    public long getuHistory() {
        return value;
    }
}
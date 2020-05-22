public class StringLengthAverager {
    private int stringsSeen;
    private int totalLengthSeen;

    public void accept(String s) {
        stringsSeen++;
        totalLengthSeen += s.length();
    }

    public double getAverageLength() {
        return ((double)totalLengthSeen) / stringsSeen;
    }
}
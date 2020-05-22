public class LeadVO implements Comparable<LeadVO> {
    private Date date;

    // other properties, getters and setters

    @Override
    public int compareTo(LeadVO other) {
        return date.compareTo(other.getDate());
    }
}
public enum Priority implements Comparable<Priority> {
    CRITICAL("Critical", 10), HIGH("High", 8), MEDIUM("Medium", 5), LOW("Low", 3), NONE("Not a priority", 0);
    String title;
    int value;

    public Priority(String aTitle, int aValue) {
        title = aTitle;
        value = aValue;
    }
    public int compareTo(Priority another) {
        return Integer.valueOf(value).compareTo(Integer.valueOf(another.value));
    }
    public String toString() {
        return title;
    }
}
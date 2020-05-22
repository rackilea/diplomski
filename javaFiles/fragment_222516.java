public class NameComparator implements Comparator<String> {

    private String name;

    public NameComparator(String name) {
        this.name = name;
    }

    @Override
    public int compare(String lhs, String rhs) {
        if (lhs.startsWith(name) && rhs.startsWith(name)) {
            return lhs.compareTo(rhs);
        } else if (lhs.startsWith(name)) {
            return -1;
        } else if (lhs.startsWith(name)) {
            return 1;
        }

        return lhs.compareTo(rhs);
    }
}
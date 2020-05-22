public class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1 != null && s2 != null)
            return s1.compareTo(s2);
        return (s1 == null) ? 1 : -1;
    }
}
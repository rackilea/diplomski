public class NumericalStringComparator implements Comparator<String> {
    @Override
    public int compare (String s1, String s2) {
        int i1 = Integer.parseInt(s1.split(" ")[0]);
        int i2 = Integer.parseInt(s2.split(" ")[0]);
        int cmp = Integer.compare(i1, i2);
        if (cmp != 0) {
            return cmp;
        }
        return s1.compareTo(s2);
    }
}
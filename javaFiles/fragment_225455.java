public class ManagerComparator implements Comparator<Manager> {
    public int compare(Manager first, Manager second) {
        int r = Integer.compare(first.getDeptNum(), second.getDeptNum());
        if (r != 0) {
            return r;
        }
        r = first.getFirstName().compareTo(second.getFirstName());
        if (r != 0) {
            return r;
        }
        return first.getLastName().compareTo(second.getLastName());
    }
}
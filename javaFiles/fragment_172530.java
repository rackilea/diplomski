public class CostComparator implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getCost().compareTo(o2.getCost());
    }
}
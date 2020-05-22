public class FictionBookComparator implements Comparator<FictionBook> {
    @Override
    public int compare(FictionBook o1, FictionBook o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
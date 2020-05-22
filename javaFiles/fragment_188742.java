public class FictionBook implements Comparable<FictionBook> {
    // snipped...

    @Override
    public int compareTo(FictionBook other) {
        return getTitle().compareTo(other.getTitle());
    }
}
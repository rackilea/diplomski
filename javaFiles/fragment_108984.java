public class SortHelper implements Comparator<ResultEmployee> {

    @Override
    public int compare(ResultEmployee o1, ResultEmployee o2) {
        int result =((Integer)o1.getFullHits()).compareTo((Integer)o2.getFullHits());
        if (result == 0) { // Full hits were the same
            result = ((Integer)o1.getHalfHits()).compareTo((Integer)o2.getHalfHits());
        }
        return result.
    }
}
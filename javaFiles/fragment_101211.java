public class CompareRowCol<T> implements Comparator<RowColElem<T>> {
    public int compare(RowColElem<T> o1, RowColElem<T> o2) {
        int cmp = Integer.compare(o1.getRow(),o2.getRow());
        if(cmp != 0) {
            return cmp;
        } else {
            return Integer.compare(o1.getCol(),o2.getCol());
        }
    }
}
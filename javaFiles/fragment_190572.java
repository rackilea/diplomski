public class GridComparator implements Comparator<GridResponse<Integer>> {
    @Override
    public int compare(GridResponse<Integer> o1, GridResponse<Integer> o2) {
        o1.setPage(1);
        return 0;
    }
}
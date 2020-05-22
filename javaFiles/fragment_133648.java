public class MyRowFilter extends LimitedRowFilter<TableModel, Integer> {

    public MyRowFilter() {
        super();
    }

    public MyRowFilter(int limit) {
        super(limit);
    }

    @Override
    public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {

        boolean included = true;
        // Do you own checking here to determine if the row should be included or
        // not
        if (included) {
            if (getLineCount() < getLineLimit()) {
                incrementLineCount();
            } else {
                included = false;
            }
        }

        return included;

    }

}
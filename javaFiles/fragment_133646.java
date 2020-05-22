public class MyRowSorter extends TableRowSorter<TableModel> {

    public MyRowSorter(TableModel model) {
        super(model);
    }

    @Override
    public void sort() {
        RowFilter<? super TableModel, ? super Integer> filter = getRowFilter();
        if (filter instanceof LimitedRowFilter) {
            LimitedRowFilter lrf = (LimitedRowFilter) filter;
            lrf.reset();
        }
        super.sort(); 
    }

}
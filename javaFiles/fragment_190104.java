public class MyTableDecorator extends TableDecorator {
    public String getCurrency() {
        MyRowType row = getCurrentRowObject();
        return row.getCurrency.format();
    }
}
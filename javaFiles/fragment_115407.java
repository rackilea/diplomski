public class InsertDataToTable {

    public static <T> void insertToTable(JTable table, List<T> domainObjects) {
        DataObjectTableModel<T> model = (DataObjectTableModel<T>) table.getModel();
        model.clearTableModelData();
        for (T domainObject : domainObject) {
           model.addDataObject(domainObject);
        }
    }

    public static <T> void insertSingleObject(JTable table, T domainObject){
        DataObjectTableModel<T> model = (DataObjectTableModel<T>) table.getModel();
        model.clearTableModelData();
        model.addDataObject(domainObject);
    }
}
public class GUI {
    private JTable table;
    private MyTableModel tableModel;
    private DataAccess dataAccess;
    ...

    public void fillTableWithDataFromDatabase() {
        List<Product> products = dataAccess.getProductsFromDatabase();
        tableModel.setProducts(products);
    }
}

public class DataAccess {
    public List<Product> getProductsFromDatabase() {
        // TODO:
        // create an empty list
        // execute a query
        // loop through each row
        // for each row, create a Product instance and add it to a list
        // return the list
    }
}
private MainController main;
@FXML private TableView<Product> productTableView;

public void setProductTableView(TableView<Product> main){
    this.productTableView = main;
}
public void setMainView(MainController main){ this.main = main; }

 void lookupProduct(String name){
    FilteredList<Product> filteredList = new FilteredList<Product>(productTableView.getItems());
    filteredList.stream()
            .filter(item -> item.getName().equalsIgnoreCase(name))
            .findAny()
            .ifPresent(item -> {
                productTableView.getSelectionModel().select(item);
                productTableView.scrollTo(item);
            });
    main.productsTableView.setItems(filteredList);
}
private TableColumn<Friend, Boolean> makeBooleanColumn(String columnName, String propertyName, int prefWidth) {
  TableColumn<Friend, Boolean> column = new TableColumn<>(columnName);
  column.setCellValueFactory(new PropertyValueFactory<Friend, Boolean>(propertyName));
  column.setCellFactory(new Callback<TableColumn<Friend, Boolean>, TableCell<Friend, Boolean>>() {
    @Override public TableCell<Friend, Boolean> call(TableColumn<Friend, Boolean> soCalledFriendBooleanTableColumn) {
      return new TableCell<Friend, Boolean>() {
        @Override public void updateItem(final Boolean item, final boolean empty) {
          super.updateItem(item, empty);

          // clear any custom styles
          this.getStyleClass().remove("willPayCell");
          this.getStyleClass().remove("wontPayCell");
          this.getTableRow().getStyleClass().remove("willPayRow");
          this.getTableRow().getStyleClass().remove("wontPayRow");

          // update the item and set a custom style if necessary
          if (item != null) {
            setText(item.toString());
            this.getStyleClass().add(item ? "willPayCell" : "wontPayCell");
            this.getTableRow().getStyleClass().add(item ? "willPayRow" : "wontPayRow");
          }
        }
      };
    }
  });
  column.setPrefWidth(prefWidth);
}
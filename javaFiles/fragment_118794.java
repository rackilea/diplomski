treeView.setCellFactory(p -> new CheckBoxTreeCell<Person>() {

 @Override
 public void updateItem(Person item, boolean empty) {
    super.updateItem(item, empty);
    if (item != null) {
       setText(item.getName());
    }
 }
});
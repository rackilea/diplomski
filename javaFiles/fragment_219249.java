FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/fxml/file"));
Parent root = loader.load();
Map<String, Object> namespace = loader.getNamespace();
for (String fxid : namespace.keySet()) {
    Object value = namespace.get(fxid);
    if (value instanceof TableColumn) {
        ((TableColumn<?,?>)value).setCellValueFactory(new PropertyValueFactory(fxid));
    }
}
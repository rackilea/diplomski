stage.setTitle(tabPane.getSelectionModel().getSelectedItem().getText());
tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
  @Override public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab) {
    stage.setTitle(newTab.getText());
  }
});
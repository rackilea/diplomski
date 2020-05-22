protected <T extends X> ComboBox<T> getComboBox(ObservableList<T> list){
    ComboBox<T> comboBox = new ComboBox<>();
    comboBox.setItems(list);
    // Setting a cell factory is probably redundant if you're only using toString...
    return comboBox;
}
listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        System.out.println("ListView selection changed from oldValue = " 
                + oldValue + " to newValue = " + newValue);
    }
});
viewCategory.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        System.out.println("index changed from " + oldValue + " to " + newValue);
    }
});
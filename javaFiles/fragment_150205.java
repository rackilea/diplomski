cityView.setCellFactory(lv -> new ListCell<City>() {
    @Override
    protected void updateItem(City city, boolean empty) {
        super.updateItem(city, empty);
        setText(empty ? null : city.getCityName());
    }
});
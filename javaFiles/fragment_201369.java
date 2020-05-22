ArrayList<Integer> baseCost = new ArrayList<>();

priceTextField.valueProperty().addListener(new ChangeListener(){
    @Override
    public void changed(ObservableValue arg0, Object arg1, Object arg2) {
        baseCost.add(Integer.parseInt(priceTextField.getText()));
    }
}
daysSlider.valueProperty().addListener(new ChangeListener() {

    @Override
    public void changed(ObservableValue arg0, Object arg1, Object arg2) {
        priceTextField.textProperty().setValue(
                String.valueOf((int) daysSlider.getValue() * baseCost.get(0) ));
    }

});
CheckBox newOption = new CheckBox();
newOption.setText("Check to see alert");
newOption.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

    @Override
    public void onValueChange(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            Window.alert("Checkbox is checked!");
        } else {
            Window.alert("Checkbox is unchecked!");
        }
    }

});
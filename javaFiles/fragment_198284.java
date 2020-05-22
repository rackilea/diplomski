view.getStreetNameTextBox().addValueChangeHandler(new ValueChangeHandler() {

    void onValueChange(ValueChangeEvent<String> event) {
        editPersonSession.updateAddressDetail(new StreetNameAddressDetail(event.getValue()));
    }

}
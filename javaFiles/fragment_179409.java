List<RadioButton> allRadioButtons = new ArrayList<RadioButton>();

// Add all radio buttons to list here

for (RadioButton radioButton : allRadioButtons) {
    radioButton.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> e) {
                updateVotes(allRadioButtons.indexOf(radioButton));
        });
}
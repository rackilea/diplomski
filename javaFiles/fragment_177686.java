private final TextWatcher fuelWatcher = new TextWatcher(){
    EditText fuelLoadField = (EditText)findViewById(R.id.Fuel_load_field);

    @Override
    afterTextChanged(Editable s){
        fuel =  = Integer.parseInt(fuelLoadField.getText());
    }
}
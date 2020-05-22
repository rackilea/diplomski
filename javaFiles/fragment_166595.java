yourSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        String chooseTime[] = {"7.00 - 9.00", "9.00 - 11.00", "11.00 - 13.00", "13.00 - 15.00", "15.00 - 17.00", "17.00 - 18.30" };
        chooseTimeConsegna = chooseTime[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
    }
});
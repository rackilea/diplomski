s1.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id3) {
    final String b = adapter.getItem(position);
        // based on b you change the property inputType of your EditText
        // for instance, if b is 'deciaml' you set as inputType 'numberDecimal'
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
});
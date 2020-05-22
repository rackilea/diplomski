s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String val = s1.getSelectedItem().toString();
        txt.setText(val);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});

s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String val = s2.getSelectedItem().toString();
        txt.setText(val);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
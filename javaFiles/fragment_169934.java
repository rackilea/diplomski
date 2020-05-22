AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String plHandText = sp1.getSelectedItem().toString();
        String dlHandText = sp2.getSelectedItem().toString();
        if ("17".equals(plHandText) && "2".equals(dlHandText)){
            Toast.makeText(MyActivity.this, "It works!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
sp1.setOnItemSelectedListener(listener);
sp2.setOnItemSelectedListener(listener);
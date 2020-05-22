textView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getItemAtPosition(i).toString().equals("Canada")) {
            Toast.makeText(getApplicationContext(), "Result Canada", Toast.LENGTH_SHORT).show();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
});
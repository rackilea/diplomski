spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if ("YourDayToHandle".equals(spinner.getSelectedItem())) {
                // do smth useful here
            }
        }

    public void onNothingSelected(AdapterView<?> parent) {}
});
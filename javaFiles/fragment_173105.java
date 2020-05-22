spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
         System.out.println("onItemSelected: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {}
});
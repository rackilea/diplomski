Presenteter p = (Presenteter) getActivity();

// ...

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        p.yourMethod(); // call a method of your Presenteter class
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
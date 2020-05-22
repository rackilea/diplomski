yourSpinner.setOnItemSelectecListener(new OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, View view,
            int pos, long id) {
        // Change color of other views by using pos argument

        // IF YOU HAVE USED String Array
        yourView.setBackgroundColor(Color.parseColor(arrayColors[pos]));

        // IF YOU HAVE USED int Array
        yourView.setBackgroundColor(arrayColors[pos]);
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
});
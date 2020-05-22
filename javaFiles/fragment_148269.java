mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position) // switch on item position in adapter

        String selection = (String) parent.getItemAtPosition(position);
        switch(selection) // switch on item String
    }
}
public void uniSpinnerSetup()
{
    ParseQueryAdapter.QueryFactory<ParseObject> factory = new ParseQueryAdapter.QueryFactory<ParseObject>() {
        public ParseQuery create() {
            ParseQuery query = new ParseQuery("University");
            return query;
        }
    };

    uniSpinner = (Spinner) findViewById(R.id.uniSpinner);

    ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, factory);
    adapter.setTextKey("name");
    uniSpinner.setAdapter(adapter);
    uniSpinner.setSelection(1);
    uniSpinner.setOnItemSelectedListener(new mySpinnerListener());
}
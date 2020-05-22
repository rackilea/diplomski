Spinner spinner;

spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

    @Override
    public void onItemSelected(AdapterView<?> arg0, View view, int arg2,
            long arg3) {

        if(! (view instanceof TextView)){
            // view is probably a textview, but record type if not.
            System.out.println("incorrect view type " + view.getClass().getSimpleName());
            return;
        }

        EditText et = (EditText) view;
        String fieldName = et.getText().toString().trim();

        //Now we got selected name, send name 
        //to a function that updates our database.

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
});
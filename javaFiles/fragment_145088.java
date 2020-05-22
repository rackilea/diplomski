String st1=null;
@Override
    protected void onPreExecute() {
        super.onPreExecute();
        EditText et1 = (EditText)findViewById(R.id.editText1);
        st1= et1.getText().toString();
        // do same for other
    }
private View.OnClickListener onSave = new MyClickListener();
//                                  the same semicolon ----^

// ...elsewhere, but inside your class...
private class MyClickListener extends View.OnClickListener() {

    public void onClick(View v) {

        EditText name=(EditText)findViewById(R.id.name);
        EditText address=(EditText)findViewById(R.id.addr);
        r.setName(name.getText().toString());
        r.setAddress(address.getText().toString());

    }
}
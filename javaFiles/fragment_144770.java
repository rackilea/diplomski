Button button = (Button)findViewById(R.id.ticket_details_sell_ticket);
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        // it will be wrong to use only "this", because it would
        // reference the just created OnClickListener object
        Intent login = new Intent(ClassName.this, Login.class);
        startActivityForResult(login, LOGIN_REQUEST);
    }
});
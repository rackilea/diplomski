btnEdit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (txtPhone.isFocusable()) {
            txtPhone.setFocusable(false);
        } else {
            txtPhone.setFocusableInTouchMode(true);
        }
    }
});

txtPhone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (txtPhone.isFocusable() == false) {
            if (txtPhone.getText().length() > 1) {
                // Call number
                // Using Toast to show listeners working first
                Toast.makeText(MainActivity.this, "Calling... " + txtPhone.getText().toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
});
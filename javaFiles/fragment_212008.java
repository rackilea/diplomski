if( getIntent().getExtras() != null) {
    Bundle b = getIntent().getExtras();
    int value = -1;

    if(b != null)
        value = b.getInt("key");

    // Add  the TextWatcher here
    edit1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Toast.makeText(MainActivity.this, "before text changed", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Toast.makeText(MainActivity.this, "on text changed", Toast.LENGTH_LONG).show();
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Toast.makeText(MainActivity.this, "after text changed", Toast.LENGTH_LONG).show();
        }
    });

    // Now the set the value in your EditText
    edit1.setText("Mywords:");
}
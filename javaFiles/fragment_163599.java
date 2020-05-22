textOut1 = (TextView) findViewById(R.id.tvGetInput1);         
textOut1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(hasFocus) {
            Intent i = new Intent(this, calculator.class);
            startActivity(i);
        }
    }
});
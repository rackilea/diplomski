final Button button = (Button) findViewById(R.id.button1);
button.setOnClickListener(mGlobalClick);

final Button button2 = (Button) findViewById(R.id.button2);
button2.setOnClickListener(mGlobalClick);

... ect

OnClickListener mGlobalListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
            //Stuff
            }
};
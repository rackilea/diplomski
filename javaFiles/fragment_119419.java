Button mButton = (Button) findViewById(R.id.my_button);
mButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        EditText t = new EditText(myContext);
        t.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        root.addView(t);
    } 
});
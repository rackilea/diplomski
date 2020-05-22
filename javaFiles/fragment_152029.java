OnClickListener onClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(action));
    }
};

Button button = (Button) findViewById(id);
button.setOnClickListener(onClickListener);
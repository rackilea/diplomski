ImageButton ib = (ImageButton) findViewById(R.id.imageButton1);
final EditText search = (EditText) findViewById(R.id.editText1);

ib.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        search.setVisibility(View.VISIBLE);
    }
});
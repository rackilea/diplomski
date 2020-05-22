Button button = findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), WebView.class);
        String webstr = web.getText().toString();
        intent.putExtra("123", webstr);
        v.getContext().startActivity(intent);
    }
});
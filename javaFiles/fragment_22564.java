TextView textView = findViewById(R.id.textView);
textView.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("category_int", 9);
        intent.putExtra("category_string", "9");
        startActivity(intent);
    }
});
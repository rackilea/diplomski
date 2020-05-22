mbuttonNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ClientList.class);
        intent.putExtra("VariableName", "Fred");
        startActivity(intent);
    }
});
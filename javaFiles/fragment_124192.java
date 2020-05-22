final Button button1 = (Button) findViewById(R.id.mybutton);
button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        navigationView.setCheckedItem(R.id.nav1);
    }
});
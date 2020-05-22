final Button button1 = (Button) findViewById(R.id.mybutton);
button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav1));
    }
});
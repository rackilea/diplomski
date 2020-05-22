Button button = (Button) findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        //set the event you want to perform when button is clicked
        //you can go to another activity in your app by creating Intent
        Intent intent = new Intent(getApplicationContext, Activity2.class);
        startActivity(intent);
    }
});
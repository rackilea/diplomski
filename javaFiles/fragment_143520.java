Button clickButton = (Button) findViewById(R.id.clickButton);
clickButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(this, MyActivityName.class);
                startActivity(myIntent);
            }
});
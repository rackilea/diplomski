btn = (Button) findViewById(R.id.mainTypesBtn);

btn.setOnClickListener(new View.OnClickListener() {

@Override
    public void onClick(View v) {
        startActivity(new Intent(LoadingScreen.this, MainTypes.class));
    }
});
final Context context = this;

button = (Button) findViewById(R.id.button1);

button.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View arg0) {

        Intent intent = new Intent(context, MainActivity2.class);
                    startActivity(intent);   

    }

});
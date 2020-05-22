@Override
protected void onStart() {
    super.onStart();
    Button button = (Button) findViewById(R.id.button1);
    button.setOnClickListener( new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            //****** Uncomment the following line if you want to re-use the subactivity instead of launching a new one
            //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);

        }
    });
}
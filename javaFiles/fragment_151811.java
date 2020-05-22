private void setUpUI(){
    Button b=(Button) findViewById(R.id.button);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           Toast.makeText(getBaseContext(),"Button clicked",Toast.LENGTH_SHORT).show();
        }
    });
}
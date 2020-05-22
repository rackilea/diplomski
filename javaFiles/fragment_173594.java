final Button buttonNote = (Button) findViewById(R.id.note);

buttonNote.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
        startActivity(new Intent(LaunchActivity.this, CreateNote.class));
    }
});
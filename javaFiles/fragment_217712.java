public void addListenerOnButton() {
    final Context context = this;   
    buttonOne = (Button) findViewById(R.id.notelist);

    buttonOne.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {   
           Intent intent = new Intent(context, NoteList.class);
           startActivity(intent);
            }
        });

    buttonTwo = (Button) findViewById(R.id.notelist1);

    buttonTwo.setOnClickListener(new OnClickListener() {    
        @Override
        public void onClick(View arg0) {   
            Intent intent = new Intent(context, NoteList1.class);
            startActivity(intent);    
            }    
        });    
}
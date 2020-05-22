data_big_layout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Toast.makeText(getBaseContext(),"ID: "+ v.getTag(), Toast.LENGTH_LONG).show();
           name.setText("Clicked ID: " + v.getTag());
       }
});
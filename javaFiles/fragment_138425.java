Button b1 = (Button)findViewById(R.id.button1);
Button b2 = (Button)findViewById(R.id.button2);
// Set OnClickListeners
b1.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
       // Start Activity
       Intent intent = new Intent(this, Activity2.class);
       intent.putExtra("buttontohide", 0); // Hide Button 0
       startActivity(intent);
   }
});

b2.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
       // Start Activity
       Intent intent = new Intent(this, Activity2.class);
       intent.putExtra("buttontohide", 1); // Hide Button 1
       startActivity(intent);
   }
});
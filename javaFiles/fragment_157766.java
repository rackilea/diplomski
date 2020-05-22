// Find the View that shows the numbers category
TextView numbers = (TextView) findViewById(R.id.numbers);

// Set a click listener on that View
numbers.setOnClickListener(new View.OnClickListener() {
   // The code in this method will be executed when the numbers View is clicked on.
   @Override
   public void onClick(View view) {
       Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
       startActivity(numbersIntent);
   }
});
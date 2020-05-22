// find button with id "myButtonId" in the XML layout
Button b = (Button) findViewById(R.id.myButtonId);     

// set a listener on that button
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) { // gets called when clicked
        // button has been clicked,
        // your code here
    }
});
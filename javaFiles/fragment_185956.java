button_food   = (Button) findViewById(R.id.foodicon_layout);
button_travel = (Button) findViewById(R.id.travelicon_layout);
button_fuel   = (Button) findViewById(R.id.fuelicon_layout);
button_fetch  = (Button) findViewById(R.id.fetchicon_layout);

button_travel.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {

        int visibility = button_food.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;

        // Perform action on click
        button_food.setVisibility(visibility);
        button_fuel.setVisibility(visibility);
        button_fetch.setVisibility(visibility);
    }
});
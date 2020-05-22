// get intent object once
Intent receivedIntent = getIntent();

// get product name
String productName = receivedIntent.getExtra("name"); 

// get serving size
int servingSize = receivedIntent.getExtra("serving size");

// do the same for other props
public void onClick(View v) {
  String transport = transportSpinner.getSelectedItem().toString();
  String location = locationSpinner.getSelectedItem().toString();

  if ("Walking".equals(transport) && "Hiking".equals(location)) {
      Toast.makeText(getBaseContext(), "I'm sorry, this is not possible.", Toast.LENGTH_LONG).show();
  } else {
      Intent i = new Intent(GetDirections.this.getApplicationContext(), DirectionDisplay.class);
      i.putExtra("spinner1Value", transport); 
      i.putExtra("spinner2Value", location);
      GetDirections.this.startActivity(i);
  }
}
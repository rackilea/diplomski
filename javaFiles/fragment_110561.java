gc = new Geocoder(this); //create new geocoder instance
btnSearch.setOnClickListener(new OnClickListener() {
  public void onClick(View v) {
    String addressInput = adress.getText().toString(); //Get input text 
    try {
      List<Address> foundAdresses = gc.getFromLocationName(addressInput, 5); //Search addresses
    }
    catch (Exception e) {
      //@todo: Show error message
    }
  }
});
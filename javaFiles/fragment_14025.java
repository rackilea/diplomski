this.hotelname = (EditText) findViewById(R.id.HotelName);

//RestaurantNetwork application = (RestaurantNetwork)getApplication();
//application.setHotelName(this.hotelname.getText().toString());

 Intent intent = new Intent(view.getContext(), NetworkCommunication.class);
 intent.putExtra("hotelName",this.hotelname.getText().toString());
 startActivity(intent);
Button btnActivityB = (Button) findViewById(R.id.some_button);

    btnActivityB.setOnClickListener(new View.OnClickListener() {
                @Override
    public void onClick(View view) {
              Intent intent = new Intent(this, MapActivity.class);

              LatLng latLng = new LatLng(-20.65,-40.79) //Or any other value...

              intent.put("LatLng", latLng); 

              startActivity(intent);
          }
 });
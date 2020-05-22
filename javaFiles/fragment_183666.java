mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {


                //Here using setters 
                marker1 marker1 = new marker1();
                marker1.setMarkerLat(marker.getPosition().latitude);

                Toast.makeText(Location1.this,String.valueOf(marker.getPosition().latitude),Toast.LENGTH_SHORT).show();

                Intent myintent = new Intent(Location1.this, pop.class);
                myintent.putExtra("Location",marker.getPosition().latitude);
                startActivity(myintent);
            }
        });
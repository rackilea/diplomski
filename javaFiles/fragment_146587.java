//Initialise SupportMapFragment
            SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.google_map);
            supportMapFragment.getMapAsync(this);

            btDraw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Draw Polyline on Map
                    if (polyline!=null) polyline.remove();
                       if(polylineOptions!=null){
                          //Create PolylineOptions
                    polyline = gMap.addPolyline(polylineOptions);

                    setWidth();
                   }   
                }
            });
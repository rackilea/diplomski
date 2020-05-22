MarkerOptions options = new MarkerOptions();   //options.position(LatLng);options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            options.title("Restaurante");
            options.snippet("Burger King");
            mMap.addMarker(options);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : " + vicinity);
            mMap.addMarker(markerOptions);//esto añade los marcadores
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));//aqui se le pone el color a los marcadores
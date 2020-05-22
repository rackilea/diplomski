final AutocompleteOptions options = AutocompleteOptions.newInstance();
        final Autocomplete autocomplete = Autocomplete.newInstance(input.getElement(), options);    
        final InfoWindow infowindow= InfoWindow.create();
        autocomplete.addPlaceChangeHandler(new PlaceChangeMapHandler(){

            @Override
            public void onEvent(PlaceChangeMapEvent event) {
                PlaceResult place=autocomplete.getPlace();
                String address=place.getAddress_Components().get(0).getShort_Name();
                infowindow.setContent(place.getName()+", "+address);        
                LatLng latLng = LatLng.create(place.getGeometry().getLocation().getLatitude(), place.getGeometry().getLocation().getLongitude());
                addMarker(latLng,place,infowindow); 
                map.setCenter(latLng);
                map.setZoom(17.0);              
            }
        });
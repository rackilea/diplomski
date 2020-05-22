for (int i = 0; i < latLngList.size(); i++) {
        if (stares.get(i).equals("gresit")) {
            color = BitmapDescriptorFactory.HUE_BLUE;
        } else if (stares.get(i).equals("salvat")) {
            color = BitmapDescriptorFactory.HUE_GREEN;
        } else {
            color = BitmapDescriptorFactory.HUE_RED;
        }
        mMap.addMarker(new MarkerOptions()
                .position(latLngList.get(i))
                .title("Din CSV!")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(color))

    };
try {
    mMap.addMarker(new MarkerOptions().position(new 
            LatLng(Double.parseDouble(table.getX()), 
                    Double.parseDouble(table.getY()))));
} catch (NumberFormatException ex){
    //do anything when exception occurs
}
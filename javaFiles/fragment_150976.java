List<LatLng> names = new ArrayList<>();
for(int i=0; i<mis_localizaciones.size();i++){
    names.add(new LatLng(Double.parseDouble(mis_localizaciones.get(i).getLatitude()), Double.parseDouble(mis_localizaciones.get(i).getLongitude())));
}

// now use names.get(0), names.get(1), names.get(2), etc...
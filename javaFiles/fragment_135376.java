List<Double> latArrayList = new ArrayList<Double> ();
latArrayList.add(125.87); //or whatever

for(int i = 0; i < latArrayList.size(); i++){
    theMap.addMapMarker(new MapMarkerDot(latArrayList.get(i), longArrayList.get(i)));
}
for(int i=0; i<array.length; i++){
    eachElement = array[i];
    if(eachElement.getLongtitude()!=null){
      JSONObject geometry = new JSONObject();
      JSONArray JSONArrayCoord = new JSONArray();
      JSONObject newFeature = new JSONObject();

      JSONArrayCoord.add(0, eachElement.getLongtitude());
      JSONArrayCoord.add(1, eachElement.getLatitude());

      geometry.put("type", "Point");
      geometry.put("coordinates", JSONArrayCoord);
      feature.put("geometry", geometry);
      features.add(newFeature);
      featureCollection.put("features", features);
    }
  }
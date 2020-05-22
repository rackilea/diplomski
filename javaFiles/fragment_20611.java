//get the inner map for "M"
HashMap<Double, Integer> innerMap= aircraftHandling.get("M");
if (innerMap == null) {
    //if it does not exist instantiate it
    innerMap= new HashMap<Double, Integer>();
    aircraftHandling.put("M", innerMap);
}
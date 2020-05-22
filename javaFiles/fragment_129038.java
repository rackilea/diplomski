// Get Geometry object (however you do it)
// Then use the getter method to get coordinates variable
// Parse the nested arrays

ArrayList<Double[]> values = geometry.getCoordinates().get(0).get(0).get(0);

// You can now access the values, e.g.
Double[] firstArray = values.get(0);
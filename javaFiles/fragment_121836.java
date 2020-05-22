// points[] is your array of geo points
var boundbox = new map.LatLngBounds();
for (var i=0; i<points.length; i++){ 
  boundbox.extend(points[i]);
}
var center = boundbox.getCenter();
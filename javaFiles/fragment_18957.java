deltaLat = radiusInKm / 111.1;
deltaLong = radiusInKm / kmInLongitudeDegree;

minLat = lat - deltaLat;  
maxLat = lat + deltaLat;
minLong = long - deltaLong; 
maxLong = long + deltaLong;
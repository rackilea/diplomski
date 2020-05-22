Location locationOne = new Location("point First");

locationOne.setLatitude(latA);

locationOne.setLongitude(lngA);

Location locationTwo = new Location("point Second");

locationTwo.setLatitude(latB);

locationTwo.setLongitude(lngB);

float distance = locationOne.distanceTo(locationTwo);
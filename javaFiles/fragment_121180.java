Optional<Location> locationOptional = Optional.ofNullable(location);
String longitudeResult = locationOptional
        .map(Location::getLongitude)
        .map(Object::toString)
        .orElse("Address_Longitude is empty or null;");
String latitudeResult = locationOptional
        .map(Location::getLatitude)
        .map(Object::toString)
        .orElse("Address_Latitude is empty or null;");
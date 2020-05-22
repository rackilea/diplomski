geocodeBody.getLocations().stream()
.filter(location -> 
    location.getAddress() != null 
    && StringUtils.isNotEmpty(location.getAddress().getLon())
    && StringUtils.isNotEmpty(location.getAddress().getLat())
).forEach(location -> {
      Stops.add(location.getAddress().getLat()); // adding latitude
      Stops.add(location.getAddress().getLon()); // adding longitude
    });
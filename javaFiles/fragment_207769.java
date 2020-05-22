CircleOptions circleOptions = new CircleOptions()
    .center(new LatLng(37.4, -122.1))
    .radius(1000)); // In meters

// Get back the mutable Circle
Circle circle = myMap.addCircle(circleOptions);
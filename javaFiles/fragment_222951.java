// Instantiates a new Polyline object and adds points to define a rectangle
PolylineOptions rectOptions = new PolylineOptions()
        .add(new LatLng(37.35, -122.0))
        .add(new LatLng(37.45, -122.0))  // North of the previous point, but at the same longitude
        .add(new LatLng(37.45, -122.2))  // Same latitude, and 30km to the west
        .add(new LatLng(37.35, -122.2))  // Same longitude, and 16km to the south
        .add(new LatLng(37.35, -122.0)); // Closes the polyline.

// Set the rectangle's color to red
rectOptions.color(Color.RED);

// Get back the mutable Polyline
Polyline polyline = myMap.addPolyline(rectOptions);
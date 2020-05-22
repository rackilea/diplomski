DirectionsRoute[] routes = DirectionsApi.newRequest(context)
    .mode(TravelMode)
    .origin(startPoint)
    .destination(endPoint)
    .waypoints(wayPoints)
    .optimizeWaypoints(true) // Add this
    .await();
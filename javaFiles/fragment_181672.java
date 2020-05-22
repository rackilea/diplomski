public DirectionsApiRequest waypoints(java.lang.String... waypoints) {
   int numOfWayPoints = waypoints.length;
   for (int i = 0 ; i < numOfWayPoints ; i++) {
      doSomethingWithTheWayPoint(waypoints[i]);
   }
   // or
   for (java.lang.String waypoint : waypoints) {
      doSomethingWithTheWayPoint(waypoint);
   }
}
java.lang.String[] waypoints = {"Ltlng1", "Ltlng2"}; // fill the array
   .... 
   .waypoints(waypoints); // call the method, passing the array instead of a list of parameters

   // or
   ArrayList<java.lang.String> waypointsList = new ArrayList<>();
   waypointsList.add("Ltlng1");
   waypointsList.add("Ltlng2"); 
   // etc
   .... 
   .waypoints(waypointsList.toArray(new java.lang.String[])); // call the method, passing the array of strings obtained from a list
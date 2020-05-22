public static boolean determineRoute(City from, City to, ArrayList<City> flightRoute)
{
   ArrayList<City> connections = new ArrayList<City>();
   connections = to.getConnections(); //or from.getConnections(); what ever makes sense

   //connections is not used, so I assume you want to put them into flightRoute
   flightRoute.addAll(connections);

   return true; 
}
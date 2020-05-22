public static void main(String[] args)
{
    ArrayList<Flight> flightList = new ArrayList<Flight>();
    flightList.add(new Flight(...)); //The ... within the braces depends on your Flight constructor
    flightList.add(new Flight(...)); //The ... within the braces depends on your Flight constructor
    flightList.add(new Flight(...)); //The ... within the braces depends on your Flight constructor

    Airport airport = new Airport(flightList); //Now airport has a list of flights    
}
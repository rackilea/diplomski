public class ATControl{
    private ArrayList<Aircraft> currentFlights;

    //
    //Constructor gets called on initialization
    public ATControl(){
        currentFlights = new ArrayList<Aircraft>();
    }

    //
    //User input should be handled in main class and passed into this
    public void addFlight(int flightNum, int speed, int altitude){
        Aircraft newCraft = new Aircraft();

        //
        //assign the properties we just got from the user to our new aircraft
        newCraft.setFlightNumber(flightNum);
        newCraft.setSpeed(speed);
        //
        //Now add our new flight to the list of current flights
        currentFlights.add(newCraft);

    }


}
class FlightStatusEvent {

    int status;
    Flight flight;

    FlightStatusEvent(int statusCode, Flight flight) {
        this.status = statusCode;
        this.flight = flight;
    }

    public int getStatus() {
        return this.status;
    }

    public Flight getFlight() {
        return this.flight;
    }

}

class Flight extends Observable {

    int status;// 0 = on time, -1 = late, +1 = before scheduled time

    public void updateStatus(int statusCode) {

        this.status = statusCode;
        FlightStatusEvent fsce = new FlightStatusEvent(status, this);
        setChanged();
        notifyObservers(fsce);

    }

}

class FlightStatusMonitor implements Observer {

    public ArrayList<Flight> flights = new ArrayList<Flight>();

    public void displayStatusOfFlights() {
        for(Flight f : flights) {
            System.out.println("Flight " + f + ", status = " + f.status);
        }
    }

    public void update(Observable flight, Object flightStatusEvent) {
        displayStatusOfFlights();
    }

    public static void main(String[] args) {
        FlightStatusMonitor fsm = new FlightStatusMonitor();

        Flight f1 = new Flight();
        f1.addObserver(fsm);
        Flight f2 = new Flight();
        f2.addObserver(fsm);

        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(f1);
        flights.add(f2);

        fsm.flights = flights;
        fsm.displayStatusOfFlights();

        // this will trigger observer pattern event.
        f1.updateStatus(1);
    }

}
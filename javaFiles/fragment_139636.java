public Carpark (String locations, int room){
    location = locations;
    capacity = room;
    //this creates an array with the max number of spots
    carsParked = new String[capacity];
    //also good idea to init 
    carsIn = 0; //initial number of cars parked
}
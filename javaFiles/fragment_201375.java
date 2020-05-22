public static void main(String[] args) throws Exception {

    //create an elevator at a random floor
    Elevator elevator = new Elevator(new Random().nextInt(11));

    int elevatorFloor = elevator.getCurrentFloor();
    System.out.println("The elevator is now on floor " + elevatorFloor);

    System.out.print("Which floor are you at now? (0-10) where 0 = basement: ");
    int personFloor = Keyboard.readInt();
    if(personFloor == elevatorFloor) {
        System.out.println("Enter the elevator");
    }
    else {
        elevator.goToFloor(personFloor);
    }

    System.out.println("To which floor would you want to go (0-10) where 0 = basement");
    int destinationFloor = Keyboard.readInt();
    elevator.goToFloor(destinationFloor);
}
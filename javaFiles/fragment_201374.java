public class Elevator {

    // the floor that the elevator is currently on
    private int currentFloor;

    /**
     * Creates an elevator at the specified floor.
     *
     * @param initialFloor the initial floor
     */
    public Elevator(int initialFloor) {
        this.currentFloor = initialFloor;
    }

    /**
     * @return the currentFloor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Moves the elevator to the specified floor.
     *
     * @param floor the floor to go to.
     */
    public void goToFloor(int floor) {
        if (floor < currentFloor) {
            goDownToFloor(floor);
        } else if (floor > currentFloor) {
            goUpToFloor(floor);
        }
        System.out.println("The elevator has arrived");
    }

    /**
     * Moves the elevator up to the specified floor.
     *
     * @param floor the floor to go up to.
     */
    private void goUpToFloor(int floor) {
        System.out.println("The elevator is on its way up...");

        //TODO: put loop to go up to the floor here
    }

    /**
     * Moves the elevator down to the specified floor
     *
     * @param floor the floor to go down to.
     */
    private void goDownToFloor(int floor) {
        System.out.println("The elevator is on its way down...");

        //TODO: put loop to go down to the floor here        
    }
}
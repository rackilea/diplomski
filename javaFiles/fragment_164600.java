public class Elevator {
    private int currentFloor;

    public Elevator() {
        currentFloor = 0;
    }

    public void selectFloor() {
        Scanner scnr = new Scanner(System.in);
        int newFloor;

        System.out.println("Enter the floor you'd like to go to ==> ");
        newFloor = scnr.nextInt();
        if (newFloor > 100 || newFloor < 0 || newFloor == 13) {
            System.out.println("Invalid selection");
        }

        else {  // The if was not necessary
            int direction = 0;
            if(currentFloor < newFloor){
                direction = 1; // going up;
            } else if (currentFloor > newFloor) {
                direction = -1; //going down;
            } else {
                direction = 0; //going nowhere;
            }
            for (; currentFloor != newFloor; currentFloor += newFloor)
                System.out.println("..." + i);
                System.out.println("Ding!");
        }
    }

    public void fireAlarm() {
        System.out.println("Danger, you must exit the building now!");
    }
}
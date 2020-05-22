public static void selectFloor() {
    Scanner scnr = new Scanner(System.in);
    int newFloor= 0; //initalize to 0

    while (newFloor != -1) { //loop forever until user gives -1 as input
        System.out.println("Enter your destination floor >>> ");
        System.out.println("To exit the programm enter: -1"); //tell the user how to exit
        newFloor = scnr.nextInt();
        if (newFloor > 7 || newFloor < 0) {
           //if logic
        } else {  
           //else logic
        }
    }
}
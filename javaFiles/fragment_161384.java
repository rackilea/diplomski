import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);
    private static Dock[] dock1 = new Dock[10];

    public static void main(String[] args) {

        initializeDock();

        Scanner scan = new Scanner(System.in);


        while(true) {

            System.out.println("Choose an option: 1-3");
            System.out.println("1. Dock");
            System.out.println("2. Undock");
            System.out.println("3. Status");

            int menu = scan.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("1. Dock");
                    dock();
                    break;
                case 2:
                    System.out.println("2. Undock");
                    undock();
                    break;
                case 3:
                    System.out.println("3. Status");
                    printArray();
                    break;
                case 4:
                    System.out.println("4. Exit");
                    System.exit(0);
                default:
                    System.out.println("No such option");
                    break;
            }
        }
    }

    private static void initializeDock() {
        for (int i = 0; i < 5; i++) {
            dock1[i] = new Dock(Ship.ShipSize.CARGO);
        }
        for (int i = 5; i < 10; i++) {
            dock1[i] = new Dock(Ship.ShipSize.CONTAINER);
        }
    }

    public static void dock() {

        int dockCapacity = 0;

        System.out.println("Enter ship's name: ");
        String name = scan.nextLine();

        Ship.ShipSize size = null;
        while(size == null) {
            System.out.println("Enter ship's size: ");
            String stringSize = scan.nextLine();
            size = Ship.ShipSize.of(stringSize);
            if (size == null) {
                System.out.println("Could not read ship size. Only cargo and container are allowed.");
            }
        }

        // check that ship fits into any dock
        if (size == Ship.ShipSize.CONTAINER) {
            long numberOfContainerShips = Arrays.stream(dock1).map(Dock::getDockedShip).filter(Objects::nonNull).filter(Ship::isContainer).count();
            if (numberOfContainerShips >= 5) {
                System.out.println("No place for a ship that large. Aborting.");
                return;
            }
        }

        System.out.println("Enter the ships dock:");
        Integer dockNumber = null;
        while(dockNumber == null) {
            dockNumber = scan.nextInt();
            if (dockNumber < 0 || dockNumber > dock1.length - 1) {
                System.out.println("Illegal dock number. Only numbers between 0 and " + dock1.length + " are allowed.");
                dockNumber = null;
            }
        }

        Dock dock = dock1[dockNumber];
        if (dock.getDockedShip() != null) {
            System.out.println("Dock reserved - couldn't dock");
            return;
        }
        if (dock.getSupportedSize() == Ship.ShipSize.CARGO && size == Ship.ShipSize.CONTAINER) {
            System.out.println("Dock too small - couldn't dock");
            return;
        }

        dock.setDockedShip(new Ship(name, size));
    }

    public static void undock(){

        System.out.println("Status of ships: ");
        printArray();
        System.out.println("Enter ship's name to undock: ");
        String name = scan.nextLine();
        for(int i = 1; i < dock1.length; i++){
            if(dock1[i].getDockedShip() != null && dock1[i].getDockedShip().getShipName().equals(name)){
                dock1[i] = null;
                System.out.println("Ship removed");
                break;
            }
            else{
                System.out.println("Ship not docked here");
            }
        }

    }

    public static void printArray() {

        System.out.println("Docks:");

        for(int i = 0; i < dock1.length; i++)
        {
            if(dock1[i].getDockedShip() == null)
            {
                System.out.println("Dock " + i + " is empty. Size: " + dock1[i].getSupportedSize().name().toLowerCase());
            }
            else
            {
                System.out.println("Dock " + i + ": " + dock1[i].getDockedShip().getShipName() + " " + dock1[i].getDockedShip().getShipSize().name().toLowerCase());
            }
        }
    }
}
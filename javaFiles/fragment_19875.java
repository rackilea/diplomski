public class TestProgram {

    public static final Room[] rooms = new Room[] {
            new Room("GARDEN0001", "NorthWest Garden View", 45.0),
            new PremiumRoom("POOL0001", "Poolside Terrace", 90.0, 1, 150, 50),
            new Room("GARDEN0003", "North Garden View", 35.0),
            new Room("GARDEN0005", "West Garden View", 35.0),
            new PremiumRoom("POOL0002", "Poolside Private", 125.0, 2, 100, 75),
            new Room("GARDEN0004", "South Garden View", 52.0) 
    };

    private static void displayrooms() {
        rooms[0].print();
        System.out.println();
        rooms[1].print();
        System.out.println();
        rooms[2].print();
        System.out.println();
        rooms[3].print();
        System.out.println();
        rooms[4].print();
        System.out.println();
        rooms[5].print();
    }

    public static void main(String[] args) {
        displayrooms();
    }
}
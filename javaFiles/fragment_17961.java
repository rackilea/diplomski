import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Room yard;
    private Room frontdoor;
    private Room hallway;
    private Room bathroom;
    private Room lounge;
    private Room kitchen;
    private Room bedroom;
    private Room basementdoor;
    private Room basement;
    private Room exit;
    private Room current;
//create an inventory
    private ArrayList<String> inventory = new ArrayList<String>();

    public Game() {
        yard = new Room("You're standing in open area.\n"
                        + "There is a house to the north.\n");

        frontdoor = new Room("You come to an old timber door, but it's locked.\n"
                        + "There's a key on the ground. Talk about security...\n"
                        + "There's a yard to the south.\n");
        frontdoor.setKey("Front door key");

        hallway = new Room("A hall stretches out into darkness.\n"
                        + "There is a small flicker of light to the North.\n"
                        + "There's a faint dripping sound to the west"
                        + "There's a strange smell comming from the east");

        bathroom = new Room("You enter what looks like a bathroom. It doesn't look like anyones cleaned it it months.\n"
                        + "There's four numbers scratched into the wall - '1517'.\n"
                        + "The hall is to the east.");

        kitchen = new Room("You come into a kitchen, there's moldy food still in grocery bags on the bench.\n"
                        + "You see a sandwhich and pick it up to investigate. Fortunately it looks fresh, and you're pretty hungry.\n"
                        + "The hall is back to the west.");
        kitchen.addItem("Mouldy Sandwhich?");

        lounge = new Room("You come to a dimly lit loungeroom.\n"
                        + "The couches have been toppled over, a book case lies fallen on the floor. The embers are still hot and flickering in the fireplace.\n"
                        + "There's a door on the western wall.");

        bedroom = new Room("You walk into a bedroom.\n"
                        + "There's snoring comming from a huddled lump on the bed. Better be quiet.\n"
                        + "There's a large metal door on the southern wall");

        basementdoor = new Room("There's no breaking through this thing, it's too solid.\n"
                        + "There's a small keypad next to the door. Hmm?\n");

        basement = new Room("The code unlocks the door. You climb down a dimly lit staircase into what looks like a basement.\n"
                        + "Suddenly, you hear some yelling from upstairs and some footsteps making their way down the staircase!\n"
                        + "There's a window to north, quick!\n");

        exit = new Room("You crawl through the window, out into the open and run down the street.\n"
                        + "Why did you even go into that house in first place?\n");

        current = yard;

        //Connect the rooms
        yard.connectNorth(frontdoor);
        frontdoor.connectNorth(hallway);
        hallway.connectNorth(lounge);
        hallway.connectWest(bathroom);
        kitchen.connectWest(hallway);
        lounge.connectWest(bedroom);
        basementdoor.connectNorth(bedroom);
        basement.connectNorth(basementdoor);
        basement.connectNorth(exit);
    }

    /**
     * Play the interactive text game.
     *
     * Reads commands from the given input, line by line.
     *
     * @param in
     */
    private void take(String item) {
        if (current.contains(item) == true) {
            current.removeItem(item); // can't get this to work
            inventory.add(item);
            System.out.println("You picked up the " + item + "and stashed it away");
        } else {
            System.out.println("Unknown object '" + item + "'.");
        }
    }

    private void drop(String item) {
        if (current.contains(item) == true) {
            inventory.remove(item);
            current.addItem(item); // or this
            System.out.println("You dropped the " + item + "and left it in the " + current);
        } else {
            System.out.println("Unknown object '" + item + "'.");
        }
    }

    public void play(Scanner in) {
        current.describe();
        while (current != exit) {
            String line = in.nextLine().toLowerCase();
            if (line.equals("quit")) {
                System.out.println("You gave up!");
                break;
            } else if (line.startsWith("go ")) {
                String dir = line.substring(3);
                Room next = current.getNextRoom(dir);
                if (next == null) {
                    System.out.println("You cannot go " + dir + " from here.");
                } else {
                    if (next.isLocked() && inventory.contains(next.requiredKey())) {
                        current = next;
                        System.out.println("You use the " + next.requiredKey() + " to unlock the next room...");
                        current.describe();
                    } else if (next.isLocked()) {
                        System.out.println("That room is locked and you don't have the required key");
                    } else {
                        current = next;
                        current.describe();
                    }
                }
            } else if (line.startsWith("take ")) {
                take(line.substring(5));
            } else if (line.startsWith("print inventory")) {
                System.out.print(inventory);
            } else {
                System.out.println("Unknown command '" + line + "'.  Try go/take/quit.");
            }
        }
    }

    /**
     * Starts the whole game.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play(new Scanner(System.in));
    }

    public class Room {

        private String description;
        private Room north;
        private Room east;
        private Room south;
        private Room west;
//add a list of empty items to each room
        private ArrayList<String> items = new ArrayList<>();

        private String key; //null means no key

        public Room(String desc) {
            description = desc;
        }

        public void setKey(String key) {
            this.key = key;
        }

        /**
         * Connect the west exit of this room to the 'other' room. It automatically
         * makes the connection in both directions.
         *
         * @param other
         */
        public void connectWest(Room other) {
            this.west = other;
            other.east = this;
        }

        public void connectNorth(Room other) {
            this.north = other;
            other.south = this;
        }

        /**
         * Prints a description of this room and its contents.
         */
        public void describe() {
            final StringBuilder itemsString = new StringBuilder("");
            for (String item : items) {
                itemsString.append(" ").append(item);
            }
            System.out.println(itemsString.toString());
            System.out.println(description);
        }

        public boolean isLocked() {
            return key != null;
        }

        public String requiredKey() {
            return key;
        }

        /**
         * Try to move in the given direction from this room.
         *
         * @param dir Should be "north", "east", "south" or "west".
         * @return the new room.
         */
        public Room getNextRoom(String dir) {
            Room nextRoom = null;

            if (dir.equals("north")) {
                nextRoom = north;
            } else if (dir.equals("east")) {
                nextRoom = east;
            } else if (dir.equals("south")) {
                nextRoom = south;
            } else if (dir.equals("west")) {
                nextRoom = west;
            } else {
                System.out.println("Error: unknown direction " + dir);
            }
            return nextRoom;
        }

        public boolean contains(String item) {
            return items.contains(item);
        }

        public void addItem(String item) {
            items.add(item);
        }
        public void removeItem(String item) {
            items.remove(item);
        }
    }
}
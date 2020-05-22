public class Room {

    //...

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
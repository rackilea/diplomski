public class Room {

    private boolean isCreatureInRoom;

    private int x;
    private int y;

    private String description;

    public Room(int x, int y, String description) {
        this.x = x;
        this.y = y;
        this.description = description;
        this.isCreatureInRoom = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCreatureInRoom() {
        return isCreatureInRoom;
    }

    public void setCreatureInRoom(boolean isCreatureInRoom) {
        this.isCreatureInRoom = isCreatureInRoom;
    }

}
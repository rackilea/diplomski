public class Room {

    private String roomId;
    private String description;
    private double dailyRate;
    private char status;

    public Room(String roomId, String description, double dailyRate) {
        this.roomId = roomId;
        this.description = description;
        this.dailyRate = dailyRate;
        this.status = 'A';
    }

    public void print() {
        StringBuilder str = new StringBuilder();

        str.append("Room ID: ").append(roomId).append("\n")
                .append("Description: ").append(description).append("\n")
                .append("Daily-Rate: ").append(dailyRate).append("\n")
                .append("Status: ").append(status);

        System.out.println(str.toString());
    }
}
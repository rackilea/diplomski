public class Room {

    int roomNumber;
    String roomType;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Room Number : ").append(roomNumber);
        builder.append("\n");
        builder.append("Room Type : ").append(roomType);
        builder.append("\n");
        return builder.toString();
    }
}
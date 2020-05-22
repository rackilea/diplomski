public class House {
  private List<Room> rooms;

  public House() {
    rooms = new ArrayList<Room>();
  }

  public void addRoom(...) {
    Room room = new Room(...);
    rooms.add(room);
  }

  public int numRooms() {
    return rooms.size();
  }

  public Room getRoom(int roomNumber) {
    return rooms.get(roomNumber);
  }
}

public class Room {
  public Room(...) {
    ...
  }
}
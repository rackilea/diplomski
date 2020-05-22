public class Room
{
   private String _name;
   private int _seats;

   public Room(final String name, final int seats) {
      _name = name;
      _seats = seats;
   }

   public String getName() {
      return _name;
   }

   public int getAvailableSeats() {
      return _seats;
   }

   public void setName(final String name) {
      _name = name;
   }

   public void setAvailableSeats(final int seats) {
      _seats = seats;
   }
}

public class Theatre
{
   private static final List<Room> ROOMS;

   static {
      ROOMS = new ArrayList<Room>(10);
      ROOMS.add(new Room("Room 1", 120));
      ROOMS.add(new Room("Room 2", 180));
      ROOMS.add(new Room("Room 3", 100));
      ROOMS.add(new Room("Room 4", 120));
      ROOMS.add(new Room("Room 5", 200));
      ROOMS.add(new Room("Room 6", 180));
      ROOMS.add(new Room("Room 7", 80));
      ROOMS.add(new Room("Room 8", 50));
      ROOMS.add(new Room("Room 9", 120));
      ROOMS.add(new Room("Room 10", 150));
   }

   public static void addRoom(final String roomName, final int seatsAvailable) {
      ROOMS.add(new Room(roomName, seatsAvailable));
   }

   public static void printRooms() {
      for (final Room room : ROOMS) {
         System.out.println(room.getName());
      }
   }

   public static void updateSeats() {
      final Room room = ROOMS.get(MainActivity.filmSelectionNumber);
      room.setAvailableSeats(room.getAvailableSeats() - Basket.seatsBooked);
   }

   public static int getSeats() {
      final Room room = ROOMS.get(MainActivity.filmSelectionNumber);
      Basket.theatre += room.getName();

      return room.getAvailableSeats();
   }
}
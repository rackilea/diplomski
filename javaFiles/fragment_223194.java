String roomName = scanner.hasNext() ? scanner.next() : "";
Room room = null;

if(roomName.equals("room")) {
   room = new Room(roomName);
}
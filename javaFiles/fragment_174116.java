List<Room> rooms = RoomsWindow.loadRoom();
// This may throw an exception, so you'll want to deal with that
String roomNumber = Integer.parseInt(txtNumber.getText());
boolean found = false;
for (Room room : rooms) {
    if (room.getNumber() == roomNumber) {
        found = true;
        break;
    }
}
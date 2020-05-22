Room match = rooms.stream().filter(room -> room.getNumber() == roomNumber).orElse(null);
if (match != null) {
    // Found room
} else {
    // Did not find foom
}
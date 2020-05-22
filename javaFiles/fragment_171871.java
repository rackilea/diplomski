public static Room room() { //done
    Room referenceRoom = new Room();
    referenceRoom.setRoomId(100);
    referenceRoom.setRoomIdentifier("Room XXXX");
    referenceRoom.setRoomNumber("Room Number XXX");
    referenceRoom.setDoorPlate("Door Plate XXX");
    referenceRoom.setRoomZone("Room Zone XXX");
    referenceRoom.setBarcode("2345234");
    referenceRoom.setSeats("20 Seats");
    referenceRoom.setStatus(Room.RoomStatus.Available);
    // don't set "foreign keys" yet
    return referenceRoom;
}

// do similar pruning for the other factories

Room room = room();
Location location = location();
room.setLocation(location);
location.setRoom(room);

// create new void methods that wire up the relationships like this
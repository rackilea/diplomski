Map<Person,Room> personRoom;
SetMultimap<Room,Person> roomPeople;
void addPersonToRoom(Person p,Room r){
    Room currentRoom = personRoom.get(p);
    if (currentRoom != null)
        roomPeople.remove(currentRoom, p);
    personRoom.put(p,r);
    roomPeople.put(r,p);
}
Set<Person> getPeopleInRoom(Room r){
    return roomPeople.get(r);
}
Room getRoomForPerson(Person p){
    return personRoom.get(p);
}
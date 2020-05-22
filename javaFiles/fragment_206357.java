public Integer create() { // Previously newRoomNum()
    Integer newRoomNum = ... // Create id
    Date date = ... // Create date when the id should be deleted again
    if(map.isEmpty()) // Only schedule when empty
        timer.schedule(new DeleteKeyTask(newRoomNum), date);
    map.put(newRoomNum, date);
    return newRoomNum;
}
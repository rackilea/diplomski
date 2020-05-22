private final Timer timer; // Initialised somewhere

public Integer newRoomNum() {
    Integer newRoomNum = ... // Create id
    Date date = ... // Create date when the id should be deleted again
    timer.schedule(new DeleteKeyTask(newRoomNum), date);
    return newRoomNum;
}
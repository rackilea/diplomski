public class User {

...
    private ChatRoom currentRoom;
...
    public void leaveRoom()
    {  
        if (currentRoom != null) {
            currentRoom.removeUser(this);
            currentRoom = null;
        }
    }
....
}
public class Room
{
       private int roomNumber;
       private Student allotedTo;      
              public int getRoomNumber() {
              return roomNumber;
       }
       public void setRoomNumber(int roomNumber) {
              this.roomNumber = roomNumber;
       }
       public Student getAllotedTo() {
              return allotedTo;
       }
       public void setAllotedTo(Student allotedTo) {
              this.allotedTo = allotedTo;
       }
       @Override
       public String toString() {
       return "Room [roomNumber=" + roomNumber + ", allotedTo=" + allotedTo.getName()
                           + "]";
       }      
}
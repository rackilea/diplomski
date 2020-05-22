@Entity
public class Booking {

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
}

@Entity
public class Room {

    @ManyToOne
    @JoinColumn( name="roomType_id" )
    private RoomType roomType;

}
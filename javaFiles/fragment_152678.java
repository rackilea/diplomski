@Entity
@Table(name="HOUSE")
public class HouseEntity {

    @Id
    @Column(name="HOUSE_ID")
    private int houseId;

    @Column(name="HOUSE_NAME")
    private String houseName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;

    //Getters, setters, equals, and hashCode omitted
}


@Entity
@Table(name="ROOM")
public class RoomEntity {

    @Id
    @Column(name="ROOM_ID")
    private int roomId;

    @ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "HOUSE_ID", referencedColumnName = "HOUSE_ID", nullable = false)
    private HouseEntity house;

    @Column(name="ROOM_NAME")
    private String roomName;

    //Getters, setters, equals, and hashCode omitted
}
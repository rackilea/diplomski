@Entity
@Table(name="hotels")
public class HotelEntity {
  .
  .
  .
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
  private Set<RoomEntity> rooms = new HashSet<>(0);
  .
  .
  .
}

@Entity
@Table(name="rooms")
public class RoomEntity {
 .
 .
 .
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "hotel_id", nullable = false)
 private Hotel hotel;
 .
 .
 .

}
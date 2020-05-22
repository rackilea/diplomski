public class Event extends Model{
    @Id
    public Long id;

    @Column("user")
    public User user;

    @Column("place")
    public Place place;
}
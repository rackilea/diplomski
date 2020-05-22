@Entity(name = "Event")
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Type(type = "com.vladmihalcea.book.hpjp.hibernate.type.CharacterType")
    @Column(name = "event_type")
    private Character type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }
}
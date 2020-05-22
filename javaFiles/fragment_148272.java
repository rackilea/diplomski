@Entity
@Table(name = "info")
public class Info {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "i_id")
    private long id;


    @OneToMany(mappedBy="info" cascade = CascadeType.ALL)
    private List<Event> events;

    String detailDesc;

    //set both sides of the relationship
    public void addEvent(Event event){
        event.setInfo(this);
        events.add(event);
    }

    public List<Event> getEvents(){
        //return unmodifiable list or iterator to force clients through addEvent() method
    }

}


@Entity
@Table(name = "event") 
 public class Event {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "e_id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "i_id")
    private Info info;

   private Date date;

 }
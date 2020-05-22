@Entity
@Table(name = "game")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private GameId id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean postponed;
    private Boolean played;
    private String gameDescr;

    private League league;
    private Season season;
    private Club clubHome;
    private Club clubAway;

    public Game() {
    }

    @EmbeddedId
    public GameId getId() {
        return id;
    }
    //everything else stays the same
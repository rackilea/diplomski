@Entity(name = "Clubber")
public class Clubber{

    @Id
    @GeneratedValue
    @Column(name = "Clubber_Id")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @ElementCollection
    @CollectionTable(name="CLUB_ASSIGNMENTS", joinColumns=@JoinColumn(name="Clubber_Id", referencedColumnName="Clubber_Id"))
    @Column(name="CLUB_DATE")
    @MapKeyJoinColumn(name = "Club_ID", referencedColumnName="Club_ID")
    private Map<Club, Date> joinDate = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public Map<Club, Date> getJoinDate() {
        return joinDate;
    }

    public Collection<Club> getClubs() {
        return joinDate.keySet();
    }

    public void addClub(Club club) {
        joinDate.put(club, new Date());
        //clubs.add(club);
        club.getClubbers().add(this);
    }
}

@Entity(name = "Club")
public class Club {

    @Id
    @GeneratedValue
    @Column(name = "Club_ID")
    private Integer id;

    @ManyToMany(mappedBy = "joinDate", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Clubber> clubbers = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public List<Clubber> getClubbers() {
        return clubbers;
    }
}
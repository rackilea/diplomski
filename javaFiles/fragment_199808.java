@Entity
@Table(name = "time_fields")
public class TimeFields {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long timeId;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateTime;
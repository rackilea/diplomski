@Entity(name = "Title")
@Table(name = "titles")
public class Title implements Serializable {

    @EmbeddedId
    private TitleId titleId;

    @Column(name = "to_date")
    private java.sql.Date toDate;

    @MapsId("empNumber")
    @JoinColumn(name = "emp_no")
    @ManyToOne
    private Employee employee;

}
@Embeddable
public class TitleId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "emp_no")
    private long empNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "from_date")
    private java.sql.Date fromDate;
}
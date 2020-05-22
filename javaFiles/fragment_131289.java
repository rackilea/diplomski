@Entity
@NamedQueries( { @NamedQuery(name = ChangeEntry.FIND_ALL_CHANGEENTRIES, query = "SELECT c FROM ChangeEntry c") })
public class ChangeEntry implements Serializable {
    public final static String FIND_ALL_CHANGEENTRIES = "findAllChangeEntries";

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID", unique = true, nullable = false)
    @NotNull
    private ChangeEntryDetails changeEntryDetails;

    public void addDetails(ChangeEntryDetails details) {
        this.changeEntryDetails = details;
        details.setChangeEntry(this);
    }

    // constructor, getters and setters
}
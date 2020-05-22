@Entity
public class ChangeEntryDetails implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false, mappedBy = "changeEntryDetails")
    @NotNull
    private ChangeEntry changeEntry;

    // constructor, getters and setters
}
@Entity
public class Error {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String id;

    @OneToMany(mappedBy = "errorId", fetch = FetchType.LAZY)
    private Collection<MainError> mainErrorCollection;

    public Error() {
    }

    public Error(String id) {
        this.id = id;
    }

    //getter and setter methods

}
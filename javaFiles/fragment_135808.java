public class Publication{

    @Id
    @Column(name="PUBLICATIONID")
    private String id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publications", fetch = FetchType.EAGER)
    private Collection<Author> authors;
}
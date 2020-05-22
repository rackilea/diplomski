public class Author{

    @Id
    @Column(name = "AUTHORID")
    private String id;

    @ManyToOne
    @JoinTable(name = "author_publications", joinColumn = @JoinColumn(name = "AUTHORID"), inverseJoinColumn = @JoinColumn(name = "PUBLICATIONID"))
    private Publication publications;
}
@Entity
@Indexed
public class ClassA {
    @Id
    @DocumentId
    private Integer id1;

    @Field
    private Integer description;

    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @IndexEmbedded
    @JoinColumn(name="id1", referencedColumn="id1", updatable = false, insertable = false)
    Set<ClassB> b;

    // getters and setters
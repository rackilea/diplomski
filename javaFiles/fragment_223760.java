@Entity
public class ClassB {
    @EmbeddedId
    @DocumentId
    private ClassB_Pk id;

    @ContainedIn
    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="id2", referencedColumnName="id2", insertable=false, updatable=false)
    ClassA a;


// other properties
// setters and getters
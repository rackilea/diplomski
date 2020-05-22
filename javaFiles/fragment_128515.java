@Entity
@Table(name = "myTable")
@Access(AccessType.FIELD)
public class MyClass {
    ...
    @Transient // Do not store this field
    protected BitSet tags;

    @Access(AccessType.PROPERTY) // Store the property instead
    @Column(name = "Tags")
    byte[] getTagsInDbRepresentation() {
        ... // Do conversion
    }

    void setTagsInDbRepresentation(byte[] data) {
        ... // Do conversion
    }
    ...
}
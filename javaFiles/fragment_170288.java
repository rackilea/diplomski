@Entity
@Table(name = "PROPERTY")
public class FullProperty extends PropertySuper {

    @ManyToOne
    @JoinColumn(name="TYPE_CODE")
    private FullPropertyType type;

    @OneToMany(mappedBy="property", fetch=FetchType.EAGER)
    private Set<FullPropertyPhoneNumber> phoneNumbers;

    ...getters and setters...
}
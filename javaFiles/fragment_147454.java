@Entity
@Table(name="PhoneOwner")
public class PhoneOwner {
    @Id
    @Column(name="owner_id")
    long id;

    @ElementCollection
    @CollectionTable(name = "Phone", joinColumns = @JoinColumn(name = "owner_id"))
    List<Phone> phones = new ArrayList<Phone>();
}

@Embeddable
class Phone {
    @Column(name="type", nullable = false)
    String type;
    @Column(name="number", nullable = false)
    String number;
}
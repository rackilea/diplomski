@Entity
@Table(name = "RECIPIENT")
public class Recipient implements Serializable {

@ManyToMany(targetEntity = Email.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinTable(name = "EMAIL_RECIPIENT", joinColumns = {@JoinColumn(name = "RECIPIENT_ID", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "EMAIL_ID", nullable = false)})
@Fetch(FetchMode.SELECT)
 private List<Email> emails = new ArrayList<>()
...getter setters
}
@Entity
@Table(name = "RECIPIENT")
public class Recipient implements Serializable {

@ManyToMany(targetEntity = Email.class)
@JoinTable(name = "EMAIL_RECIPIENT", joinColumns = {@JoinColumn(name = "RECIPIENT_ID", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "EMAIL_ID", nullable = false)})
@Fetch(FetchMode.SELECT)
private Set<Email> emails = new HashSet<>();

}

@Entity
@Table(name = "EMAIL")
public class Email implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "EMAIL_ID")
private Integer emailId;

@ManyToMany(targetEntity = Recipient.class, mappedBy = "emails"وcascade = CascadeType.ALL)
private Set<Recipient> recipients = new HashSet<>();

}
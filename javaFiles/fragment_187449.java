@Entity
@Table(name = "sms_history")
public class SmsHistory implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@OneToMany(mappedBy = "smsHistory", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
private List<SmsHistoryRecipient> smsHistoryRecipients = new ArrayList<>();
...
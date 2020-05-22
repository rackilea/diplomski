@Embeddable
public class SmsHistoryRecipientId implements Serializable { 

@ManyToOne
@JoinColumn(name="sms_history_id",  updatable = false, insertable = false, referencedColumnName = "id")
private SmsHistory smsHistoryId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="recipient_id",  updatable = false, insertable = false, referencedColumnName = "id")
private Recipient recipient;
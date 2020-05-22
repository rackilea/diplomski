@Entity
@Table(name = "sms_history_recipient")
public class SmsHistoryRecipient implements Serializable {

@EmbeddedId
private SmsHistoryRecipientId smsHistoryRecipientId;

...
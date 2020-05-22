@Entity
@Table(name = "event_account_rel")
@IdClass(EventAccountRelationPk.class)
public class EventAccountRelation {

  @Id
  private Long eventId;

  @Id
  private Long accountId;

  @MapsId("eventId")
  @ManyToOne(optional = false)
  @JoinColumn(name = "event_id", nullable = false, updatable = false)
  private Event event;

  @MapsId("accountId")
  @ManyToOne(optional = false)
  @JoinColumn(name = "account_id", nullable = false, updatable = false)
  private Account account;

  @Column(name = "moderator", nullable = false)
  private Boolean moderator = Boolean.FALSE;

  ...

}
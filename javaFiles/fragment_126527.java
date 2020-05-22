@Entity
@Table(name = "event_account_rel",
       uniqueConstraints = {@UniqueConstraint={"EVENT_ID","ACCOUNT_ID"}})
public class EventAccountRelation {

  @Id
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "event_id")
  private Event event;

  @ManyToOne(optional = false)
  @JoinColumn(name = "account_id")
  private Account account;

  @Column(name = "moderator", nullable = false)
  private Boolean moderator = Boolean.FALSE;

  ...

}
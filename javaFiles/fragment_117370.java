@Entity
public class Message implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(name = "INCOME_MESSANGE", nullable = false)
  private String incomingMessage;

  @ManyToOne
  @JoinColumn(name = "USERNUMBER", nullable = false)
  private Contact contact;

  @Transient
  ChatApplicationRemote chatApplicationRemote;
  ..
}


@Entity
public class Contact implements Serializable {

  private static final long serialVersionUID = -6855140755056337926L;

  @Column(name = "NAME", nullable = false)
  private String name;
  @Column(name = "PRENAME", nullable = false)
  private String vorname;
  @Column(name = "IP", nullable = false)
  private String ip;
  @Column(name = "PORT", nullable = false)
  private Integer port;
  @Id
  @Column(name = "USERNUMBER", nullable = false)
  private String usernumber;

  @OneToMany(mappedBy = "incomingMessage")
  private LIst<Message> messages;
  ..
}
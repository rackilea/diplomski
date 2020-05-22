@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = receiver)
    private List<Message> messagesRecived;

    @OneToMany(mappedBy = sender)
    private List<Message> messagesSended;
}
@Entity
@Table(name="groups")
@Inheritance(strategy=InheritanceType.JOINED)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
...
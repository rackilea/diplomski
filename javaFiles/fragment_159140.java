@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    @Column(name="POST_ID")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
      name="POST_KEYWORD",
      joinColumns={@JoinColumn(name="POST_ID", referencedColumnName="POST_ID")},
      inverseJoinColumns={@JoinColumn(name="KEYWORD_ID", referencedColumnName="ID")})
    private Set<Keyword> keywords = new HashSet<>();
}
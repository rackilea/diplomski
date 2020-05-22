@Entity
@Table(name="purchase", schema = "sch_sales")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="id_purchase")
    private List<Article> listArticle;

 }
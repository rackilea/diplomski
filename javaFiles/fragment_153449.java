@Entity
@Table(name="purchase", schema = "sch_sales")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    @JoinTable(name="join_purchase_article", schema = "sch_sales", joinColumns = @JoinColumn(name="sales_fk"), inverseJoinColumns = @JoinColumn(name="article_fk"))
    private List<Article> listArticle;

 }
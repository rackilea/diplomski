@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id", unique=true, nullable=false)
    private Long languageId;

    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="language")
    private List<ProductDescription> productDescriptions = 
         new ArrayList<ProductDescription>();

    // Other fields + getters and setters
}
@Entity
@Table (name="project")
@SequenceGenerator(name="seq_project",sequenceName="BI***********.SEQ_PROJECT", allocationSize=1, initialValue=1)
public class Project {

//Fields
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,  generator="seq_project")
@Column(name="PROJECT_ID")
private int id;
@Column(name="PROJECT_CODE")
private String projectCode;
@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
@JoinColumn(name="PRODUCT_ID",insertable=true,
updatable=true,nullable=false,unique=true)
private Product product;
@Column(name="DESCRIPTION")
private String description;

@Entity
@Table (name="product")
@SequenceGenerator(name="seq_product",sequenceName="BI***********.SEQ_PRODUCT", allocationSize=1, initialValue=1)
public class Product {

//Fields
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_product")
@Column(name="PRODUCT_ID")
private int id;
@Column(name="PRODUCT_NAME")
private String productName;
@Column(name="DESCRIPTION")
private String description
@OneToOne (mappedBy="PRODUCT_ID",fetch=FetchType.EAGER)
private Project project;
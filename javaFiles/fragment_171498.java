@Entity    
public class Job { 
@Id
@GeneratedValue
private Integer id;

private String title;

@ManyToMany(fetch=FetchType.EAGER,cascade = { CascadeType.MERGE })
@JoinTable(name = "jobs_categories", joinColumns = @JoinColumn(name = "jobs_id") , inverseJoinColumns = @JoinColumn(name = "categories_id") )
private Set<Category> categories = new HashSet<Category>();
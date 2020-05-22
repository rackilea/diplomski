@Entity
@Table(name = "table_name")
public class TableName{

......

@Transient
private Long parentId;

...... 

@ManyToOne(fetch = FetchType.LAZY, optional=true)
@JoinColumn(name="parent_id")
private TableName parent;

@OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
private Set<TableName> children = new HashSet<TableName>();
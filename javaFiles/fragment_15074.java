@Entity
public class CategoryEntity extends Model {
    @Id
    private String categoryId;

    private String name;
    private Integer level;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(         name = "category_category",
                 joinColumns = @JoinColumn(name = "source_category_id"), 
          inverseJoinColumns = @JoinColumn(name = "target_category_id"))
    public List<CategoryEntity> category_entity_lists = new ArrayList<CategoryEntity>();
}
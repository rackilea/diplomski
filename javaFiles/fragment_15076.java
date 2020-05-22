@Entity
public class CategoryEntity extends Model {
    @Id
    private String categoryId;

    private String name;
    private Integer level;

    @OneToOne
    public CategoryList this_category_list;

    @ManyToMany(mappedBy="category_list")
    public List<CategoryList> in_other_category_lists = new ArrayList<CategoryList>();
}
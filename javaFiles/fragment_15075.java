@Entity
public class CategoryList extends Model
{
    @Id
    public Long id;

    @ManyToMany
    @JoinTable(name="categorylist_category")
    public List<CategoryEntity> category_list = new ArrayList<CategoryEntity>();
}
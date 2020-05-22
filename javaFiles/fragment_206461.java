@Component
public class CategoriesCache {
    @Inject
    CategoryRepositoy repo;

    private List<Category> cachedCategories;

    @PostConstruct
    void init() {
        cachedCategories = repo.findAll();
    }
}
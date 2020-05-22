@Controller
public class CategoryController {

    private SimpleCategoryDAO simpleCategoryDAO;
    private SimpleGifDAO simpleGifDAO;

    @Autowired
    public void setSimpleGifDAO(SimpleGifDAO simpleGifDAO) {
        this.simpleGifDAO = simpleGifDAO;
    }

    @Autowired
    public void setSimpleCategoryDAO(SimpleCategoryDAO simpleCategoryDAO) {
        this.simpleCategoryDAO = simpleCategoryDAO;
    }

    @RequestMapping("/categories")
    public String getAllCategories(ModelMap modelMap) {
        modelMap.put("categories", simpleCategoryDAO.getAllCategories());
        return "categories";
    }

    @RequestMapping("/category/{categoryID}")
    public String getGifsByCategoryID(@PathVariable int categoryID, ModelMap modelMap) {
        modelMap.put("gifs", simpleGifDAO.findGifsByCategoryID(categoryID));
        modelMap.put("category", simpleCategoryDAO.getCategoryByID(categoryID));
        return "category";
    }
}
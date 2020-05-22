@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SimpleCategoryDAO simpleCategoryDAO;

    @Before
    public void setup() {
        final CategoryController categoryController = new CategoryController();

        //notice here I'm setting the mocked dao here
        // if you didn't use @RunWith(MockitoJUnitRunner.class)
        // you can do: simpleCategoryDAO = Mockito.mock(SimpleCategoryDAO.class);

        categoryController.setSimpleCategoryDAO(simpleCategoryDAO);

        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void categories_ShouldRenderCategoriesView() throws Exception {
        List<Category> ALL_CATEGORIES = Arrays.asList(
                new Category(1, "Funny"),
                new Category(2, "JoyFul")
        );
        Mockito.when(simpleCategoryDAO.getAllCategories()).thenReturn(ALL_CATEGORIES);

        mockMvc.perform(get("/categories"))
                //.andExpect((MockMvcResultMatchers.model()).attribute("categories",ALL_CATEGORIES));
                .andExpect(MockMvcResultMatchers.view().name("categories"));
    }
}
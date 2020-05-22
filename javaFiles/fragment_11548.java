@Configuration
public class MyConfig() {

    @Bean
    public List<todos> todos() {
        List<todos> todos = new ArrayList<>();
        //todos.add(...)
    }
}

@Controller
public class SecondController {

    @Autowired
    private List<todos> todos;  

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) throws IOException {

        // Use todos 

        return "list-todos";
    }
}
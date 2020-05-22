@Controller
public class ExecuteController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping(path="execute")
    public String execute() {
        return new Date().toString() + ": executed " + (jdbcTemplate == null);
    }

}
// a rest controller
@RestController
@RequestMapping("/someData")
public class SomeController {

    @Autowired
    private SomeDataDAO someDataDAO;

    @GetMapping
    public SomeData getSomeData() {
        return someDataDao.getSomeData().orElse(null);
    }

}
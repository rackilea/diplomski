@RestController
public class EmployeeController {

    private final EmployeeDao dao;

    @Autowired
    public EmployeeController(EmployeeDao dao) {
        this.dao=dao;
    }


    // for insertion into database

    @RequestMapping(value="/",method=RequestMethod.POST)
    public String insertValue(Employee e) {
        e.setId(1);
        e.setName("james");
        e.setSalary(7000);
        dao.insertvalue(e);
        return "value saved to database";
    }

    //for updation

    @RequestMapping(value="/",method=RequestMethod.PUT)
    public String updateValue(Employee e) {
        dao.updateValue(e);
        return "value updated to database";
    }

    //for deletion

    @RequestMapping(value="/",method=RequestMethod.DELETE)
    public String deleteValue(Employee e) {
        ht.delete(e);
        return "value deleted from database";
    }

    // get stored values from d.b

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getValue() {
        return ""+dao.findAll();    
    }

    // to get particular value from d.b

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public String getSpecificValue(@PathVariable int id) {
        return ""+dao.findOne(id);
    }
}
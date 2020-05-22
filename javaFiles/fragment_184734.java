@Component
public class EventCreator {

  @Autowired
  private DepartmentDAO deptDao;

  public Event createEvent(){
   //logic here
   //I need to use the deptDao here.

  //deptDao.getAllDepartments();

  }
}
@RequestMapping("/students")
@RestController
public class StudentsController {

    @Autowired
    StudentServices st;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public Iterable<Students> getAllStudents() {
          Iterable<Students> list = st.getAllStudents();
          return list
}
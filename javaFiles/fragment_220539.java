@Controller
public class StudentsController {

private ArrayList<student> students = new ArrayList<>();

private final IStudentsRepository studentsRepository;

@Autowired
public StudentsController(final IStudentsRepository studentsRepository) {
   this.studentsRepository = studentsRepository;
}
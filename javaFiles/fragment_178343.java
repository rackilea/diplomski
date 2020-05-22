@Repository
public class EmployeeDAOImpl {
}

@Service
public class EmployeeService {  
    @Autowired
    private EmployeeDAO employeeDAO;
}

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
}
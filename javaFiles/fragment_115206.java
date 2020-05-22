@Named("empMB")
@Scope("request")
public class EmployeesManagedBean implements Serializable {

    @Inject
    IEmployeesService employeesService;
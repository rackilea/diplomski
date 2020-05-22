@Controller
public class EmployeeController extends AbstractCrudController {    
    // (...rest of dependency and methods....)

    @Transactional
    @RequestMapping(value = urlFragment + "/create", method = RequestMethod.GET)
    public String createNewEmployee(Model model) {
        prepareEmployeeForm(model);
        return "crud/employee/create";
    }

    @Transactional
    @RequestMapping(value = urlFragment + "/create", method = RequestMethod.POST)
    public String processNewEmployee(Model model, @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (!result.hasErrors()) {
            // Look here it is important line!
            entityManager.merge(employee.getUser());
        }

        prepareEmployeeForm(model);

        return "crud/employee/create";
    }
}
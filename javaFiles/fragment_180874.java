@Validated
@RestController
public class EmployeeController {

    @PostMapping("/employees")
    public List<Employee> newEmployee(@RequestBody @Valid Employee newEmployee) {
        return Collections.singletonList(newEmployee);
    }

    @PostMapping("/employees/bulk")
    public List<Employee> newEmployee(@RequestBody @Valid Map<String, Employee> newEmployees) {
        return new ArrayList<>(newEmployees.values());
    }
}
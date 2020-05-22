package mohamedmiledijpa;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Get("/")
    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    @Post("/")
    public Employee create(@Body Employee employee) {
        return employeeRepository.save(employee);
    }
}
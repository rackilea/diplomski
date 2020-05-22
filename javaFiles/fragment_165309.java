package mohamedmiledijpa;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(@NotNull Employee employee);
    Employee update(@NotNull Employee employee);
    List<Employee> findAll();
    Optional<Employee> findById(@NotNull Long id);
}
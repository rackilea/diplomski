package mohamedmiledijpa;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee save(@NotNull Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee update(@NotNull Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        String qlString = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(qlString, Employee.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }
}
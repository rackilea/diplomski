package org.sec3.jpa.bean;

import org.springframework.data.repository.CrudRepository;

public interface TestEmployeeRepository extends JpaRepository<JpaEmployee, Long> {

}
package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable

import com.example.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT "
        + "e.eid, "
        + "e.firstname, "
        + "e.lastname, "
        + "e.dept) "
        + "FROM Employee e")
    public Page<Employee> getAllEmployees(Pageable pageable);

}
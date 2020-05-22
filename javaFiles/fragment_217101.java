@Test
public void createEmployeeThrowsExceptionWhenEmployeeExists() {
 final Employee employee= new Employee();       
 employee.setEmpId(empId);

final List<Employee> employeeList = new ArrayList<Employee>();
employeeList.add(new employee());

// given
given(entityManager.createNamedQuery("employeeRegistryImpl.findByEmployeeId")).willReturn(query);
given(query.setParameter("empId", empId)).willReturn(query);
given(query.getResultList()).willReturn(employeeList);

// when
try {
    employeeRegistryImpl.createUser(employeeList);      
} catch (Exception e) {
// then
    e.getErrorCode());
}

// then
verify(entityManager, Mockito.times(1)).
createNamedQuery("employeeRegistryImpl.findByEmployeeId");
}
@Bean
public EmployeeDAO getContactDAO() {
    return new EmployeeDAOImpl(getDataSource());
}

@Bean
public EmployeeController getEmployeeController() {
    return new EmployeeController();
}
private static void createEmployee()
{
    final String uri = "http://localhost:8080/springrestexample/employees";
    MultiValueMap<String> headers = new MultiValueMap<>();
    //set headers
    HttpEntity<EmployeeVO> newEmployee = new HttpEntity<>(new EmployeeVO(-1, "Adam", "Gilly", "test@email.com"),headers);

    RestTemplate restTemplate = new RestTemplate();
    EmployeeVO result = restTemplate.postForObject( uri, newEmployee, EmployeeVO.class);

    System.out.println(result);
}
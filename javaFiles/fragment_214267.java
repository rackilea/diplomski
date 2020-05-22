final SimpleJdbcCall updateEmployeeCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("update_employee");
final Map<String, Object> params = new HashMap<>();
params.put("p_id", null);
params.put("p_name", "John");
params.put("p_age", 28);
params.put("p_salary", 150000);

final Map<String, Object> result = updateEmployeeCall.execute(params);
System.out.println(result.get("returnvalue"));
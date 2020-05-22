JsonPath jsonPath = new JsonPath(json);
List<Map<String, Map<String, Object>>> list = jsonPath.getList("records");
Set<String> uniqueValues = new HashSet<>();
for (Map<String, Map<String, Object>> map : list) {
  for (Map<String, Object> m : map.values()) {
    uniqueValues.add(String.valueOf(m.get("emp_type")));
  }
}
for (String unique : uniqueValues) {
  System.out.println(unique);
}
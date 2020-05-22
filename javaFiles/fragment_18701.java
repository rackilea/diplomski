List<Map<String, Object>> cars = jdbcTemplate.queryForList("select * from cars");
for(Map car : cars) {
     String brand = (String)car.get("brand");
     String name = (String)car.getName("name");
     ....
}
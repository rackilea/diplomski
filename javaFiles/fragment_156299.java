Map map = cassandraOps.queryForMap(s);

System.out.println("id:"+map.get("id")+", name:"+map.get("name")+", age:"+map.get("age"));

Person person = cassandraOps.queryForObject(s, new RowMapper<Person>(){

    @Override
    public Person mapRow(Row row, int rowNum) throws DriverException {
        return new Person(row.getInt(0), row.getString(1),row.getInt(2));
    }
});

System.out.println("Person:"+person);
// PersonMapper.java
public class PersonMapper implements ResultSetMapper<Person> {

    public Person map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        Person person = new Person();
        person.setId(r.getInt("id"));
        person.setName(r.getString("name"));

        return person;
    }
}
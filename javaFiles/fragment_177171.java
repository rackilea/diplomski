People people = new People();  // or get it, if it's already created
while(rs.next())
{
    Person person = new Person();
    String name = rs.getString(2);
    person.setName(name);
    int id = rs.getInt(1);
    person.setId(id);
    String dept = rs.getString(4);
    person.setDept(dept);
    int age = rs.getInt(3);
    person.setAge(age);
    people.add(person);
}
return people;
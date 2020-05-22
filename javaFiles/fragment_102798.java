//Get a list of Person objects using a method
ArrayList<Person> people = getPeopleList();
Object[][] data = new Object[people.size()][];

for(int i = 0; i < people.size(); i++)
{
    Person p = people.get(i);
    data[i] = new Object[] { i, p.getName(), p.getAge(), p.getNationality() };
}
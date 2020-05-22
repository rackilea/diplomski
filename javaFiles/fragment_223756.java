class Person
{
    String address;
    String name;
    public Person(String name, String address)
    {
         this.name = name;
         this.address = address;
    }
}

...

List<Person> persons = new ArrayList<Person>();

while(result.next())
{
  String Adress= result.getString(1);
  String Name = result.getstring(2);
  persons.add(new Person(Name, Address));
}
import testPack.model.Person;
...
Person person = new Person();
...
Map<Person.Field, Optional<Instant>> updateTimes = person.getUpdateTimes();
for (Person.Field field : updateTimes.keySet())
{
    ... // do something with the key
}
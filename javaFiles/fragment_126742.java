@Test
public void testMergeObject()
{
    String jsonA = "{\"name\":\"wener\"}";
    String jsonB = "{\"age\":22}";
    Person person = new Person();
    Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new InstanceCreatorWithInstance<>(person)).create();
    gson.fromJson(jsonA, Person.class);
    gson.fromJson(jsonB, Person.class);

    assert person.getName().equals("wener");
    assert person.getAge().equals(22);
}
@Data
static class Person
{
    String name;
    Integer age;
}
static class InstanceCreatorWithInstance<T> implements InstanceCreator<T>
{
    T instance;

    public InstanceCreatorWithInstance(T instance)
    {
        this.instance = instance;
    }

    @Override
    public T createInstance(Type type)
    {
        return instance;
    }
}
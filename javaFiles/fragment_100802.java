public class TestFactory {
    public static void main(String[] args) throws Exception {
        Factory<Person> factory = new Factory<Person>();
        Person p = factory.create(Person.class, new Param());
    }
}
@RunWith(JUnit4.class)
public class MapArrayToObjectTest {
    private static ObjectMapper mapper;

    @BeforeClass
    public static void setUp() {
        mapper = new ObjectMapper();
        SimpleModule customModule = new SimpleModule("ExampleModule", new Version(0, 1, 0, null));
        customModule.addDeserializer(Person.class, new PersonDeserializer());
        mapper.registerModule(customModule);
    }

    @Test
    public void wrapperDeserializationTest() throws IOException {
        //language=JSON
        final String inputJson = "{\"persons\": [[\"John\", \"Doe\"], [\"Jane\", \"Doe\"]]}";
        PersonsListWrapper deserializedList = mapper.readValue(inputJson, PersonsListWrapper.class);
        assertThat(deserializedList.persons.get(0).lastName, is(equalTo("Doe")));
        assertThat(deserializedList.persons.get(1).firstName, is(equalTo("Jane")));
    }

    @Test
    public void listDeserializationTest() throws IOException {
        //language=JSON
        final String inputJson = "[[\"John\", \"Doe\"], [\"Jane\", \"Doe\"]]";
        List<Person> deserializedList = mapper.readValue(inputJson, mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        assertThat(deserializedList.get(0).lastName, is(equalTo("Doe")));
        assertThat(deserializedList.get(1).firstName, is(equalTo("Jane")));
    }
}

class PersonsListWrapper {
    public List<Person> persons;
}

class Person {
    final String firstName;
    final String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class PersonDeserializer extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.readValueAsTree();
        return new Person(node.get(0).getTextValue(), node.get(1).getTextValue());
    }
}
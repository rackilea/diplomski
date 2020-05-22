...
    Map<String,Object> parsed = jsonParser.parse(jsonString);
    Person thePerson = new Person(parsed);
    ...    

public class Person {
    ...
    public Person(Map<String,Object> parsed) {
        id = Integer.getInteger(parsed.getString("id"));
        name = parsed.getString("name");
        int idClient = Integer.getInteger(parsed.getString("id_client"));
        client = new Client(idClient);
    }
    ...
}
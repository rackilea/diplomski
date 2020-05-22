public class Person {
    private Integer id;
    private String name;
    //getters and setters...
}

public class PersonService {
    public Person findPerson(Integer id) {
        //code to retrieve the person object from web service call
        //and convert the response into Person object
        Person person = ...
        return person;
    }
}

@ManagedBean
@RequestScoped
public class PersonBean {
    private Integer personId;
    private Person person;

    public void findPerson() {
        PersonService personService = new PersonService();
        this.person = personService.findPerson(personId);
    }
}
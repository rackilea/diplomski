public class PersonContext{
    private UserContext userContext;
    private Person person;
    // getters and setters
}


public Person createPerson(@RequestBody PersonContext personContext)
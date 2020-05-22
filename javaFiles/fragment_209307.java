@Path("person")
public class PersonController {

    @GET
    @UserInModel
    @Produces(MediaType.TEXT_HTML)
    public PersonView person() {
        Person person = new Person("peeskillet@fake.com");
        return new PersonView(person);
    }
}
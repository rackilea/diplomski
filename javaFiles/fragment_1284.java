public class UpdatePersonTitleHandler
{
    private PersonRepository repository;

    public UpdatePersonTitleHandler(PersonRepository repository)
    {
        this.repository = repository;
    }

    public void handle(UpdatePersonTitle command)
    {
        Person person = this.repository.getById(command.personId);

        person.setTitle(command.Title);

        this.repository.Update(person);
    }
}
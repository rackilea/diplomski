@Component
public class PersonResourceProcessor implements ResourceProcessor<Resource<Person>> {

    private RepositoryEntityLinks entityLinks;

    public PersonResourceProcessor(RepositoryEntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @Override
    public Resource<Person> process(Resource<Person> resource) {
        Person person = resource.getContent();
        AnotherResource anotherResource = person.getAnotherResource()
        Link link = entityLinks.linkForSingleResource(anotherResource).withRel("anotherResource");
        resource.add(link);
        return resource;
    }
}
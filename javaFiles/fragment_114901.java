@Component
public class CaseResourceProcessor implements ResourceProcessor<Resource<Case>>
{
  @Autowired
  private RepositoryRestMvcConfiguration configuration;

  @Override
  public Resource<Case> process(Resource<Case> resource)
  {
    LinkBuilder link = configuration.entityLinks().linkForSingleResource(Submission.class,
        resource.getContent().getLatestSubmission().getId());

    resource.add(link.withRel("latestSubmission"));

    return resource;
  }
}
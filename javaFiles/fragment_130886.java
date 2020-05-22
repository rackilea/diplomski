@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectRepository repository;

    @Autowired
    @Qualifier( value = "modeshape" )
    private StorageService storageService;

    @GraphQLField @GraphQLRelayMutation
    public ProjectItem createProject( CreateProjectInput input, DataFetchingEnvironment environment ) {
        Project project = new Project( input.getName() );
        project.setDescription( input.getDescription() );
        GraphQLContext context = environment.getContext();
        Optional<Map<String, List<FileItem>>> files = context.getFiles();
        files.ifPresent( keys -> {
            List<FileItem> file = keys.get( "file" );
            List<StorageService.FileInfo> storedFiles = file.stream().map( f -> storageService.store( f, "files", true ) ).collect( Collectors.toList() );
            project.setFile( storedFiles.get( 0 ).getUuid() );
        } );
        repository.save( project );
        return new ProjectItem( project );
    }
class CreateProjectInput {
    private String name;
    private String description;
    private String clientMutationId;

    @GraphQLField
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @GraphQLField
    public String getClientMutationId() {
        return clientMutationId;
    }
}
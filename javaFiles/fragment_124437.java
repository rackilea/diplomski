public class AService {
    private final ARepository repository;
    private final EntityMapper mapper;

    public AService(ARepository repository, EntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ADto getResource(int id) {
        AnEntity entity = repository.getEntity(id);
        return mapper.toDto(entity);
    }
}
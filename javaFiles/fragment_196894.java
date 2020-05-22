public interface BaseRepo {
    // common methods
    long count();

    ...
}

@NoRepositoryBean
interface CustomCrudRepository extends CrudRepository, BaseRepo {

}

interface EntityRepository extends CustomCrudRepository {

}

class FileRepository implements BaseRepo {

    @Override
    public long count() {
        return 0;
    }
}

@Service
class SomeService {

    @Autowired
    private BaseRepo repo;
}